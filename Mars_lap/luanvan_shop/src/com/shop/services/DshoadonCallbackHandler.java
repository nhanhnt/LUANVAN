
/**
 * DshoadonCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */

    package com.shop.services;

    /**
     *  DshoadonCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class DshoadonCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public DshoadonCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public DshoadonCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for dshoadon_countpage method
            * override this method for handling normal response from dshoadon_countpage operation
            */
           public void receiveResultdshoadon_countpage(
                    com.shop.services.DshoadonStub.Dshoadon_countpageResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from dshoadon_countpage operation
           */
            public void receiveErrordshoadon_countpage(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for dshoadon method
            * override this method for handling normal response from dshoadon operation
            */
           public void receiveResultdshoadon(
                    com.shop.services.DshoadonStub.DshoadonResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from dshoadon operation
           */
            public void receiveErrordshoadon(java.lang.Exception e) {
            }
                


    }
    