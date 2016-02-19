
/**
 * MuahangCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */

    package com.shop.services;

    /**
     *  MuahangCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class MuahangCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public MuahangCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public MuahangCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getlistmh_sum method
            * override this method for handling normal response from getlistmh_sum operation
            */
           public void receiveResultgetlistmh_sum(
                    com.shop.services.MuahangStub.Getlistmh_sumResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getlistmh_sum operation
           */
            public void receiveErrorgetlistmh_sum(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getlistmh method
            * override this method for handling normal response from getlistmh operation
            */
           public void receiveResultgetlistmh(
                    com.shop.services.MuahangStub.GetlistmhResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getlistmh operation
           */
            public void receiveErrorgetlistmh(java.lang.Exception e) {
            }
                


    }
    