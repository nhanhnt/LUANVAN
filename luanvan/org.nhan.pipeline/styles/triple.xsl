<xsl:stylesheet version="1.0" 
xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
xmlns:xs="http://www.w3.org/2001/XMLSchema#"
xmlns:results="http://www.w3.org/2005/sparql-results#" >

<xsl:template match="/">
<html>
  <head>
    <title>Query Results</title>
  </head>
  <body bgcolor="#FFFFCC">
  <h1>Results</h1>
  <table border="1">
      <xsl:apply-templates/>
  </table>
  </body>
</html>
</xsl:template>

  <xsl:template match="results:head">
    <tr>
      <xsl:for-each select="results:variable">
        <th><xsl:value-of select="@name"/></th>
      </xsl:for-each>
    </tr>
  </xsl:template>
  
  <xsl:template match="results:result">
    <tr>
      <xsl:for-each select="results:binding">
        <td><xsl:value-of select="results:uri"/></td>
      </xsl:for-each>
    </tr>
  </xsl:template>
  
</xsl:stylesheet>
