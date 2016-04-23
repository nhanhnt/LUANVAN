package org.nhan.pipeline;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.Text;
import org.dom4j.io.DocumentResult;
import org.dom4j.io.DocumentSource;
import org.dom4j.io.SAXReader;
import org.nhan.sbus.Call;


public class Pipeline {
	/**
     * hash map of pipeline parmeters
     */
    private HashMap<String, Parameter> parameters;
    
    /**
     * body of pipeline as XML
     */
    private Element body = null;
    
    
    /**
     * the pipeline space name
     */
    private String pipeSpace = null;
    
    /**
     * callMap as XML document taht stores all pipelines
     */
    private static Document callMap = null ;
    
    
    /**
     * pipeline results
     */
    public String result = "";
    
    
	/**
	 * pipeline constructor, to initialize the callMap at first run 
	 */
	public Pipeline() {
		if (null == callMap){
			loadPipelines();
		}
		
	}
	
	/**
	 * reads the specific pipeline and extract the releated parameters 
	 * @param pipeName
	 */
	public void loadPipeline(String pipeName){
		setPipeSpace(pipeName.substring(0,pipeName.indexOf(':')));
		
		Node node = callMap.selectSingleNode( "/pipelines/pipeline[@name='"+pipeName+"']" );
		
		body = (Element)node;
		
		parameters = new HashMap<String, Parameter>();
		Element params = (Element)body.selectSingleNode("parameters");
		System.out.println(params.asXML());
		for ( Iterator i = params.elementIterator( "parameter" ); i.hasNext(); ) {
            Parameter param = new Parameter((Element) i.next());
            parameters.put(param.getName(),param);
        }		

	}

    
	/**
	 * constructor to load a named pipeline
	 * 
	 * @param theName pipeline name
	 */
	public Pipeline(String theName) {
		if (null == callMap){
			loadPipelines();
		}
		
		setPipeSpace(theName.substring(0,theName.indexOf(':')));
		
		Node node = callMap.selectSingleNode( "/pipelines/pipeline[@name='"+theName+"']" );
		
		body = (Element)node;
		
		parameters = new HashMap<String, Parameter>();
		Element params = (Element)body.selectSingleNode("parameters");
		System.out.println(params.asXML());
		for ( Iterator i = params.elementIterator( "parameter" ); i.hasNext(); ) {
            Parameter param = new Parameter((Element) i.next());
            parameters.put(param.getName(),param);
        }		
	}
	

	/**
	 * returns the paramneter value of the given parameter name 
	 * @param paramName the parameter name
	 * @return the value of given parameter
	 */
	public Parameter getParameter(String paramName){
		return parameters.get(paramName);
	}
	
	/**
	 * setter method for pipe space
	 * @param thePipeSpace
	 */
	private void setPipeSpace(String thePipeSpace) {
		pipeSpace = thePipeSpace;
	}
	
	/**
	 * getter method for pipe space
	 * @return the pipe space
	 */
	public String getPipeSpace(){
		return pipeSpace;
	}
	
	/**
	 * invokes the named pipeline with given parameters 
	 * @param pipeName name of th epipeline to be invoked
	 * @param xmlParams pipeline parameters
	 * @return pipeline process results as string 
	 */
	public String invokePipe(String pipeName,String xmlParams){
		result = "";
		loadPipeline(pipeName);
		setParameterValues(Util.parseParams(xmlParams));
		return processPipeline();
	}


	

	/**
	 * this is the main process that runs a pipeline at request. 
	 * @return the pipeline call results
	 */
	public String processPipeline(){
	    for ( int i = 0, size = body.nodeCount(); i < size; i++ ) {
            Node node = body.node(i);
            String name = node.getName();
            System.out.println("Name : "+i+ " : "+name);
            if (null != name){
            	// the sub-node is aso a call
            	if (name.startsWith("call")){
            		CallElement call = new CallElement((Element) node,this);
            		// the previous results will be cleaned
					if (name.equals("call-clean"))
						result = call.invoke();
					else
						result += call.invoke();
            	}
            	// the next node is an XSLT transformation
            	else if (name.equals("transform")){
					Element elm = (Element) node;
					transform(elm.attributeValue("xsl"));
            	}
            	// the pipeline process is finished, and result should be serializes
            	else if (name.equals("serialize")){
					Element elm = (Element) node;
					// call the relevant serializer (browser, form, xml, etc)
        	        Call client = new Call(elm.attributeValue("service"));
        			try {
        				Object[] content = {getResultDocument().asXML()};
        				client.invoke(elm.attributeValue("operation"),content);
        			} catch (Exception e) {
        				e.printStackTrace();
        			}
        			
            	}
            }
        }		
		return result;
	}

	/**
	 * setter method for parameter
	 * @param name name of the parameter
	 * @param val value of the parameter
	 */
	public void setParameterValue(String name, String val) {
		Parameter param = parameters.get(name);
		param.setValue(val);
		parameters.get(name).setValue(val);
	}

	/**
	 * setting all pipeline parameters from given string array
	 * @param vals parameter values
	 */
	public void setParameterValues(String[] vals) {
		int i = 0;
		for (String paramName : parameters.keySet()){
			parameters.get(paramName).setValue(vals[i++]);
		}
	}
	
	/**
	 * setting all pipeline parameters from given object array
	 * @param vals parameter values
	 */
	public void setParameterValues(Object[] vals) {
		int i = 0;
		for (String paramName : parameters.keySet()){
			parameters.get(paramName).setValue(""+vals[i++]);
		}
	}
	
	/**
	 * returns the value of given parameter name
	 * @param name name of parameter
	 * @return value of parameter
	 */
	public String getParameterValue(String name) {
		return parameters.get(name).getValue();
	}
	
	/**
	 * loads all pipelines from pipeline folder and stores them in callMap for
	 * further processes
	 */
	private void loadPipelines(){

		File dir = null;
		
		try {
			dir = PipelinePlugin.getResource("pipelines");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		SAXReader reader = new SAXReader();
		
		callMap = DocumentHelper.createDocument();
        Element root = callMap.addElement( "pipelines" );;
    
		File[] files = dir.listFiles();
		
		for(int i=0,count=files.length;i<count;i++) {
			String fileName = files[i].getName();
			if (fileName.toUpperCase().endsWith(".XML")) {
				String prefix = fileName.substring(0,fileName.indexOf('.'));
				
		        try {
					Document doc = reader.read(files[i]);
					Element pipes = doc.getRootElement();

					for ( int j = 0, size = pipes.nodeCount(); j < size; j++ ) {
			            Node node = pipes.node(j);
			            if (null != node && node.hasContent()){
			            	Element elm = (Element)node;
			            	elm.addAttribute("name", prefix+":"+elm.attributeValue("name"));
			            	root.add(elm.detach());
			            }
					}
					
				} catch (DocumentException e) {
					e.printStackTrace();
				}
			}
			
		}
		System.out.println(callMap.asXML());
	}
	
	
	/**
	 * applys an XSLT transformation to the pipeline results
	 * @param xslFile name of the XSL file
	 */
	public void transform(String xslFile){
		File xsl = null;
		try {
			xsl = PipelinePlugin.getResource("styles/"+xslFile);

	        // load the transformer using JAXP
	        TransformerFactory factory = TransformerFactory.newInstance();
	        Transformer transformer;
			transformer = factory.newTransformer( 
			    new StreamSource(xsl) 
			);

	        // now lets style the given document
	        DocumentSource source = new DocumentSource(getResultDocument());
	        DocumentResult target = new DocumentResult();
	        transformer.transform( source, target );
	
	        // return the transformed document
	        result = target.getDocument().getRootElement().asXML();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} 
	}

	/**
	 * running an XPATH query on the results to extract parameter values for 
	 * next calls
	 * 
	 * @param xpathQuery the XPATH query string
	 * @return the selected part of pipeline result as string 
	 */
	public String runXPathQuery(String xpathQuery) {
		String items="";
		List list = getResultDocument().selectNodes( "/result"+xpathQuery );

		boolean isArray = false;
		if (list.size() > 1)
			isArray = true;
			
		for (Object obj : list){
			String name = obj.getClass().getName();
			String temp = "";
			if (name.equals("org.dom4j.tree.DefaultElement"))
				temp = ((Element)obj).asXML();
			else if (name.equals("org.dom4j.tree.DefaultAttribute"))
				temp = ((Node) obj).getText();
			else if (name.equals("org.dom4j.tree.DefaultText"))
				temp = ((Text) obj).getText();
			
			if (isArray)
				items += "<item>"+temp+"</item>";
			else
				items += temp; 
		}
		return items;
	}
	
	
	/**
	 * returns the pipeline results, the results are stored locally in this class and 
	 * will be returned to the calling program in XML format
	 * 
	 * @return the pipeline results as string
	 */
	public Document getResultDocument(){
        SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			if (result.startsWith("<?xml"))
				result = result.substring(result.indexOf("?>")+2);
			doc = reader.read(new StringReader("<result>"+result+"</result>"));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return doc;
	}
	
	/**
	 * returns the paramneter value of the given parameter name 
	 * @param paramName the parameter name
	 * @return the value of given parameter
	 */
	public String[] getParamArray(){
		String[] params = new String[parameters.size()];
		int i = 0;
		for (String paramName : parameters.keySet())
			params[i++] = paramName;
		return params;
	}
}
