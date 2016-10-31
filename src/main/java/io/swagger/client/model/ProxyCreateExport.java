/**
 * Zuora REST API Reference
 *  # Introduction  Welcome to the reference documentation for the Zuora REST API!   [REST](http://en.wikipedia.org/wiki/REST_API \"http://en.wikipedia.org/wiki/REST_API\") is a web-service protocol that lends itself to rapid development by using everyday HTTP and JSON technology. REST offers the following:  *   Easy to use and learn for developers *   Works with virtually any language and platform *   Use case-oriented calls *   Well-suited for solutions that fall outside the traditional desktop application model  The Zuora REST API provides a set of use case-oriented calls that:  *   Enable Web Storefront integration between your websites. *   Support self-service subscriber sign-ups and account management. *   Process revenue schedules through custom revenue rule models.  ## Set up an API User Account  Few setup steps are required to use the Zuora REST API. No special software libraries or development tools are needed. Take a moment to set up an API user account. See [Creating an API](https://knowledgecenter.zuora.com/DC_Developers/SOAP_API/AB_Getting_started_with_the__SOAP_API/F_Create_an_API_User) user.  Note that a user role does not have write access to Zuora REST services unless it has the API Write Access permission as described in those instructions.  Use the API user account only for API calls, and avoid using it to log into the Zuora UI. Logging into the UI enables a security feature that periodically expires the account's password, which may eventually cause authentication failures with the API.  ## Authentication  There are three ways to authenticate:  * Use an authorization cookie. The cookie authorizes the user to make calls to the REST API for the duration specified in  **Administration > Security Policies > Session timeout**. The cookie expiration time is reset with this duration after every call to the REST API. To obtain a cookie, call the REST  `connections` resource with the following API user information:     *   ID     *   password     *   entity Id or entity name (Only for [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity \"Multi-entity\"). See \"Entity Id and Entity Name\" below for more information.)  *   Include the following parameters in the request header, which re-authenticates the user with each request:     *   `apiAccessKeyId`     *   `apiSecretAccessKey`     *   `entityId` or `entityName` (Only for [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity \"Multi-entity\"). See \"Entity Id and Entity Name\" below for more information.) *   For CORS-enabled APIs only: Include a 'single-use' token in the request header, which re-authenticates the user with each request. See below for more details.   ## Errors  Responses and error codes are detailed in [Responses and errors](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics/3_Responses_and_errors \"Responses and errors\").   ## Entity Id and Entity Name  The `entityId` and `entityName`  parameters are only used for  [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity).  The  `entityId` parameter specifies the Id of the entity that you want to access. The `entityName` parameter specifies the [name of the entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity/B_Introduction_to_Entity_and_Entity_Hierarchy#Name_and_Display_Name \"Introduction to Entity and Entity Hierarchy\") that you want to access. Note that you must have permission to access the entity. You can get the entity Id and entity name through the REST GET Entities call.  You can specify either the  `entityId` or `entityName` parameter in the authentication to access and view an entity.  *   If both `entityId` and `entityName` are specified in the authentication, an error occurs.  *   If neither  `entityId` nor  `entityName` is specified in the authentication, you will log in to the entity in which your user account is created.   See [API User Authentication](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity/A_Overview_of_Multi-entity#API_User_Authentication \"Zuora Multi-entity\") for more information.  ## Token Authentication for CORS-Enabled APIs  The CORS mechanism enables REST API calls to Zuora to be made directly from your customer's browser, with all credit card and security information transmitted directly to Zuora. This minimizes your PCI compliance burden, allows you to implement advanced validation on your payment forms, and makes your payment forms look just like any other part of your website.  For security reasons, instead of using cookies, an API request via CORS uses **tokens** for authentication.  The token method of authentication is only designed for use with requests that must originate from your customer's browser; **it should not be considered a replacement to the existing cookie authentication** mechanism.  See [Zuora CORS REST ](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics/G_CORS_REST \"Zuora CORS REST\")for details on how CORS works and how you can begin to implement customer calls to the Zuora REST APIs. See  [HMAC Signatures](/BC_Developers/REST_API/B_REST_API_reference/HMAC_Signatures \"HMAC Signatures\") for details on the HMAC method that returns the authentication token.   ## Zuora REST API Versions  The Zuora REST API is in version control. Versioning ensures that Zuora REST API changes are backward compatible. Zuora uses a major and minor version nomenclature to manage changes. By specifying a version in a REST request, you can get expected responses regardless of future changes to the API.   ### Major Version  The major version number of the REST API appears in the REST URL. Currently, Zuora only supports the **v1** major version. For example,  `POST https://rest.zuora.com/v1/subscriptions` .   ### Minor Version  Zuora uses minor versions for the REST API to control small changes. For example, a field in a REST method is deprecated and a new field is used to replace it.   Some fields in the REST methods are supported as of minor versions. If a field is not noted with a minor version, this field is available for all minor versions. If a field is noted with a minor version, this field is in version control. You must specify the supported minor version in the request header to process without an error.   If a field is in version control, it is either with a minimum minor version or a maximum minor version, or both of them. You can only use this field with the minor version between the minimum and the maximum minor versions. For example, the  `invoiceCollect` field in the POST Subscription method is in version control and its maximum minor version is 189.0. You can only use this field with the minor version 189.0 or earlier.  The supported minor versions are not serial, see [Zuora REST API Minor Version History](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics/Zuora_REST_API_Minor_Version_History \"Zuora REST API Minor Version History\") for the fields and their supported minor versions. In our REST API documentation, if a field or feature requires a minor version number, we note that in the field description.  You only need to specify the version number when you use the fields require a minor version. To specify the minor version, set the `zuora-version` parameter to the minor version number in the request header for the request call. For example, the `collect` field is in 196.0 minor version. If you want to use this field for the POST Subscription method, set the  `zuora-version` parameter to `196.0` in the request header. The `zuora-version` parameter is case sensitive.   For all the REST API fields, by default, if the minor version is not specified in the request header, Zuora will use the minimum minor version of the REST API to avoid breaking your integration.    ## URLs and Endpoints  The following REST services are provided in Zuora.  | Service                 | Base URL for REST Endpoints                                                                                                                                         | |-------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------| | Production REST service | https://rest.zuora.com/v1                                                                                                                                           | | Sandbox REST service    | https://rest.apisandbox.zuora.com/v1                                                                                                                                | | Services REST service   | https://services123.zuora.com/apps/v1/  (where \"123\" is replaced by the number of your actual services environment)  The production service provides access to your live user data. The sandbox environment is a good place to test your code without affecting real-world data.  To use it, you must be provisioned with a sandbox tenant - your Zuora representative can help with this if needed.   ## Requests and Responses   ### HTTP Request Body  Most of the parameters and data accompanying your requests will be contained in the body of the HTTP request.  The Zuora REST API accepts JSON in the HTTP request body.  No other data format (e.g., XML) is supported.   #### Testing a Request  Use a third party client, such as Postman or Advanced REST Client, to test the Zuora REST API.  You can test the Zuora REST API from the Zuora sandbox or  production service. If connecting to the production service, bear in mind that you are working with your live production data, not sample data or test data.  #### Testing with Credit Cards  Sooner or later it will probably be necessary to test some transactions that involve credit cards. For suggestions on how to handle this, see [Going Live With Your Payment Gateway](https://knowledgecenter.zuora.com/CB_Billing/M_Payment_Gateways/C_Managing_Payment_Gateways/B_Going_Live_Payment_Gateways#Testing_with_Credit_Cards \"C_Zuora_User_Guides/A_Billing_and_Payments/M_Payment_Gateways/C_Managing_Payment_Gateways/B_Going_Live_Payment_Gateways#Testing_with_Credit_Cards\").   ## Request IDs  As a general rule, when asked to supply a \"key\" for an account or subscription (accountKey, account-key, subscriptionKey, subscription-key), you can provide either the actual ID or the number of the entity.  ## Pagination  When retrieving information (using GET methods), the optional `pageSize` query parameter sets the maximum number of rows to return in a response. The maximum is `40`; larger values are treated as `40`. If this value is empty or invalid, `pageSize` typically defaults to `10`.  The default value for the maximum number of rows retrieved can be overridden at the method level.  If more rows are available, the response will include a `nextPage` element, which contains a URL for requesting the next page.  If this value is not provided, no more rows are available. No \"previous page\" element is explicitly provided; to support backward paging, use the previous call.  ### Array Size  For data items that are not paginated, the REST API supports arrays of up to 300 rows.  Thus, for instance, repeated pagination can retrieve thousands of customer accounts, but within any account an array of no more than 300 rate plans is returned. 
 *
 * OpenAPI spec version: 0.0.1
 * Contact: docs@zuora.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * ProxyCreateExport
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-27T21:20:45.778Z")
public class ProxyCreateExport   {
  @SerializedName("ConvertToCurrencies")
  private String convertToCurrencies = null;

  @SerializedName("Encrypted")
  private Boolean encrypted = null;

  @SerializedName("FileId")
  private String fileId = null;

  @SerializedName("Format")
  private String format = null;

  @SerializedName("Name")
  private String name = null;

  @SerializedName("Query")
  private String query = null;

  @SerializedName("Size")
  private Integer size = null;

  @SerializedName("Status")
  private String status = null;

  @SerializedName("StatusReason")
  private String statusReason = null;

  @SerializedName("Zip")
  private Boolean zip = null;

  public ProxyCreateExport convertToCurrencies(String convertToCurrencies) {
    this.convertToCurrencies = convertToCurrencies;
    return this;
  }

   /**
   *  The currencies that you want to convert transaction amounts into. You can specify any number of currencies. Specify the currencies using their [Foreign Currency Conversion](https://knowledgecenter.zuora.com/CC_Finance/Foreign_Currency_Conversion) enabled to use this field. **Character limit**: **Values**: a list of valid currency codes 
   * @return convertToCurrencies
  **/
  @ApiModelProperty(example = "null", value = " The currencies that you want to convert transaction amounts into. You can specify any number of currencies. Specify the currencies using their [Foreign Currency Conversion](https://knowledgecenter.zuora.com/CC_Finance/Foreign_Currency_Conversion) enabled to use this field. **Character limit**: **Values**: a list of valid currency codes ")
  public String getConvertToCurrencies() {
    return convertToCurrencies;
  }

  public void setConvertToCurrencies(String convertToCurrencies) {
    this.convertToCurrencies = convertToCurrencies;
  }

  public ProxyCreateExport encrypted(Boolean encrypted) {
    this.encrypted = encrypted;
    return this;
  }

   /**
   *  Exports a secure version of encrypted data source fields. such as the AchAccountNumber field of the PaymentMethod object and the DefaultPaymentMethod data souce objects. **Character limit**: 5 **Values:** true, false 
   * @return encrypted
  **/
  @ApiModelProperty(example = "null", value = " Exports a secure version of encrypted data source fields. such as the AchAccountNumber field of the PaymentMethod object and the DefaultPaymentMethod data souce objects. **Character limit**: 5 **Values:** true, false ")
  public Boolean getEncrypted() {
    return encrypted;
  }

  public void setEncrypted(Boolean encrypted) {
    this.encrypted = encrypted;
  }

  public ProxyCreateExport fileId(String fileId) {
    this.fileId = fileId;
    return this;
  }

   /**
   *  The ID of the file generated by an export query. This fiel is automatically generated when an Export object is created. Use this file ID when you download the export file. **Character limit**: 32 **Values**: automatically generated 
   * @return fileId
  **/
  @ApiModelProperty(example = "null", value = " The ID of the file generated by an export query. This fiel is automatically generated when an Export object is created. Use this file ID when you download the export file. **Character limit**: 32 **Values**: automatically generated ")
  public String getFileId() {
    return fileId;
  }

  public void setFileId(String fileId) {
    this.fileId = fileId;
  }

  public ProxyCreateExport format(String format) {
    this.format = format;
    return this;
  }

   /**
   *  The format that you want the export file to use. **Character limit**: 4 **Values**: csv, html 
   * @return format
  **/
  @ApiModelProperty(example = "null", required = true, value = " The format that you want the export file to use. **Character limit**: 4 **Values**: csv, html ")
  public String getFormat() {
    return format;
  }

  public void setFormat(String format) {
    this.format = format;
  }

  public ProxyCreateExport name(String name) {
    this.name = name;
    return this;
  }

   /**
   *  The name of the export. **Character limit**: 255 **Values**: a string of 255 characters or fewer 
   * @return name
  **/
  @ApiModelProperty(example = "null", value = " The name of the export. **Character limit**: 255 **Values**: a string of 255 characters or fewer ")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProxyCreateExport query(String query) {
    this.query = query;
    return this;
  }

   /**
   * optional
   * @return query
  **/
  @ApiModelProperty(example = "null", required = true, value = "optional")
  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public ProxyCreateExport size(Integer size) {
    this.size = size;
    return this;
  }

   /**
   *  The number of records or rows exported. This field value is null until the export status is Completed. **Character limit**: **Values**: automatically generated 
   * @return size
  **/
  @ApiModelProperty(example = "null", required = true, value = " The number of records or rows exported. This field value is null until the export status is Completed. **Character limit**: **Values**: automatically generated ")
  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public ProxyCreateExport status(String status) {
    this.status = status;
    return this;
  }

   /**
   *  The status of the export. Type: string (enum) **Character limit**: 10 **Values**: automatically generated to be one of the following values:  - Pending - Processing - Completed - Canceled - Failed 
   * @return status
  **/
  @ApiModelProperty(example = "null", value = " The status of the export. Type: string (enum) **Character limit**: 10 **Values**: automatically generated to be one of the following values:  - Pending - Processing - Completed - Canceled - Failed ")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public ProxyCreateExport statusReason(String statusReason) {
    this.statusReason = statusReason;
    return this;
  }

   /**
   *  The reason for the given status. Use this information to help ascertain why an export failed. **Character limi**t: 255 **Values**: automatically generated 
   * @return statusReason
  **/
  @ApiModelProperty(example = "null", value = " The reason for the given status. Use this information to help ascertain why an export failed. **Character limi**t: 255 **Values**: automatically generated ")
  public String getStatusReason() {
    return statusReason;
  }

  public void setStatusReason(String statusReason) {
    this.statusReason = statusReason;
  }

  public ProxyCreateExport zip(Boolean zip) {
    this.zip = zip;
    return this;
  }

   /**
   *  Indicates if you want the resulting export file to be compressed into a zip file. **Character limit**: **Values**: true, false (default) 
   * @return zip
  **/
  @ApiModelProperty(example = "null", required = true, value = " Indicates if you want the resulting export file to be compressed into a zip file. **Character limit**: **Values**: true, false (default) ")
  public Boolean getZip() {
    return zip;
  }

  public void setZip(Boolean zip) {
    this.zip = zip;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProxyCreateExport proxyCreateExport = (ProxyCreateExport) o;
    return Objects.equals(this.convertToCurrencies, proxyCreateExport.convertToCurrencies) &&
        Objects.equals(this.encrypted, proxyCreateExport.encrypted) &&
        Objects.equals(this.fileId, proxyCreateExport.fileId) &&
        Objects.equals(this.format, proxyCreateExport.format) &&
        Objects.equals(this.name, proxyCreateExport.name) &&
        Objects.equals(this.query, proxyCreateExport.query) &&
        Objects.equals(this.size, proxyCreateExport.size) &&
        Objects.equals(this.status, proxyCreateExport.status) &&
        Objects.equals(this.statusReason, proxyCreateExport.statusReason) &&
        Objects.equals(this.zip, proxyCreateExport.zip);
  }

  @Override
  public int hashCode() {
    return Objects.hash(convertToCurrencies, encrypted, fileId, format, name, query, size, status, statusReason, zip);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProxyCreateExport {\n");
    
    sb.append("    convertToCurrencies: ").append(toIndentedString(convertToCurrencies)).append("\n");
    sb.append("    encrypted: ").append(toIndentedString(encrypted)).append("\n");
    sb.append("    fileId: ").append(toIndentedString(fileId)).append("\n");
    sb.append("    format: ").append(toIndentedString(format)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    statusReason: ").append(toIndentedString(statusReason)).append("\n");
    sb.append("    zip: ").append(toIndentedString(zip)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

