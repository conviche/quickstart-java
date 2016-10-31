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
import io.swagger.client.model.POSTTierType;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.LocalDate;


/**
 * PUTScUpdateType
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-27T21:20:45.778Z")
public class PUTScUpdateType   {
  @SerializedName("billingPeriodAlignment")
  private String billingPeriodAlignment = null;

  @SerializedName("customField__c")
  private String customFieldC = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("includedUnits")
  private String includedUnits = null;

  @SerializedName("overagePrice")
  private String overagePrice = null;

  @SerializedName("price")
  private String price = null;

  @SerializedName("priceChangeOption")
  private String priceChangeOption = null;

  @SerializedName("priceIncreasePercentage")
  private String priceIncreasePercentage = null;

  @SerializedName("quantity")
  private String quantity = null;

  @SerializedName("ratePlanChargeId")
  private String ratePlanChargeId = null;

  @SerializedName("tiers")
  private List<POSTTierType> tiers = new ArrayList<POSTTierType>();

  @SerializedName("triggerDate")
  private LocalDate triggerDate = null;

  @SerializedName("triggerEvent")
  private String triggerEvent = null;

  public PUTScUpdateType billingPeriodAlignment(String billingPeriodAlignment) {
    this.billingPeriodAlignment = billingPeriodAlignment;
    return this;
  }

   /**
   * Aligns charges within the same subscription if multiple charges begin on different dates.  Values:  * `AlignToCharge` * `AlignToSubscriptionStart` * `AlignToTermStart`  Available for the following charge types:  * Recurring * Usage-based 
   * @return billingPeriodAlignment
  **/
  @ApiModelProperty(example = "null", value = "Aligns charges within the same subscription if multiple charges begin on different dates.  Values:  * `AlignToCharge` * `AlignToSubscriptionStart` * `AlignToTermStart`  Available for the following charge types:  * Recurring * Usage-based ")
  public String getBillingPeriodAlignment() {
    return billingPeriodAlignment;
  }

  public void setBillingPeriodAlignment(String billingPeriodAlignment) {
    this.billingPeriodAlignment = billingPeriodAlignment;
  }

  public PUTScUpdateType customFieldC(String customFieldC) {
    this.customFieldC = customFieldC;
    return this;
  }

   /**
   * Any custom fields defined for this object. 
   * @return customFieldC
  **/
  @ApiModelProperty(example = "null", value = "Any custom fields defined for this object. ")
  public String getCustomFieldC() {
    return customFieldC;
  }

  public void setCustomFieldC(String customFieldC) {
    this.customFieldC = customFieldC;
  }

  public PUTScUpdateType description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Description of the charge. 
   * @return description
  **/
  @ApiModelProperty(example = "null", value = "Description of the charge. ")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PUTScUpdateType includedUnits(String includedUnits) {
    this.includedUnits = includedUnits;
    return this;
  }

   /**
   * Specifies the number of units in the base set of units for this charge. Must be >=0.  Available for the following charge types for the Overage charge model:  * `Recurring` * `Usage-based` 
   * @return includedUnits
  **/
  @ApiModelProperty(example = "null", value = "Specifies the number of units in the base set of units for this charge. Must be >=0.  Available for the following charge types for the Overage charge model:  * `Recurring` * `Usage-based` ")
  public String getIncludedUnits() {
    return includedUnits;
  }

  public void setIncludedUnits(String includedUnits) {
    this.includedUnits = includedUnits;
  }

  public PUTScUpdateType overagePrice(String overagePrice) {
    this.overagePrice = overagePrice;
    return this;
  }

   /**
   * Price for units over the allowed amount.   Available for the following charge type for the Overage and Tiered with Overage charge models:  * Usage-based 
   * @return overagePrice
  **/
  @ApiModelProperty(example = "null", value = "Price for units over the allowed amount.   Available for the following charge type for the Overage and Tiered with Overage charge models:  * Usage-based ")
  public String getOveragePrice() {
    return overagePrice;
  }

  public void setOveragePrice(String overagePrice) {
    this.overagePrice = overagePrice;
  }

  public PUTScUpdateType price(String price) {
    this.price = price;
    return this;
  }

   /**
   * Price for units in the subscription rate plan.  Supports all charge types for the Flat Fee and Per Unit charge models 
   * @return price
  **/
  @ApiModelProperty(example = "null", value = "Price for units in the subscription rate plan.  Supports all charge types for the Flat Fee and Per Unit charge models ")
  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public PUTScUpdateType priceChangeOption(String priceChangeOption) {
    this.priceChangeOption = priceChangeOption;
    return this;
  }

   /**
   * Applies an automatic price change when a termed subscription is renewed. The Billing Admin setting **Enable Automatic Price Change When Subscriptions are Renewed?** must be set to Yes to use this field.  See [Define Default Subscription Settings](https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Define_Default_Subscription_Settings) for more information on setting this option.  Values:  * `NoChange` (default) * `SpecificPercentageValue` * `UseLatestProductCatalogPricing`  Available for the following charge types:  * Recurring * Usage-based  Not available for the Fixed-Amount Discount charge model. 
   * @return priceChangeOption
  **/
  @ApiModelProperty(example = "null", value = "Applies an automatic price change when a termed subscription is renewed. The Billing Admin setting **Enable Automatic Price Change When Subscriptions are Renewed?** must be set to Yes to use this field.  See [Define Default Subscription Settings](https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Define_Default_Subscription_Settings) for more information on setting this option.  Values:  * `NoChange` (default) * `SpecificPercentageValue` * `UseLatestProductCatalogPricing`  Available for the following charge types:  * Recurring * Usage-based  Not available for the Fixed-Amount Discount charge model. ")
  public String getPriceChangeOption() {
    return priceChangeOption;
  }

  public void setPriceChangeOption(String priceChangeOption) {
    this.priceChangeOption = priceChangeOption;
  }

  public PUTScUpdateType priceIncreasePercentage(String priceIncreasePercentage) {
    this.priceIncreasePercentage = priceIncreasePercentage;
    return this;
  }

   /**
   * Specifies the percentage to increase or decrease the price of a termed subscription's renewal. Required if you set the `PriceChangeOption` field to `SpecificPercentageValue`.  Decimal between `-100` and `100`.  Available for the following charge types:  * Recurring * Usage-based  Not available for the Fixed-Amount Discount charge model. 
   * @return priceIncreasePercentage
  **/
  @ApiModelProperty(example = "null", value = "Specifies the percentage to increase or decrease the price of a termed subscription's renewal. Required if you set the `PriceChangeOption` field to `SpecificPercentageValue`.  Decimal between `-100` and `100`.  Available for the following charge types:  * Recurring * Usage-based  Not available for the Fixed-Amount Discount charge model. ")
  public String getPriceIncreasePercentage() {
    return priceIncreasePercentage;
  }

  public void setPriceIncreasePercentage(String priceIncreasePercentage) {
    this.priceIncreasePercentage = priceIncreasePercentage;
  }

  public PUTScUpdateType quantity(String quantity) {
    this.quantity = quantity;
    return this;
  }

   /**
   * Quantity of units; must be greater than zero. 
   * @return quantity
  **/
  @ApiModelProperty(example = "null", value = "Quantity of units; must be greater than zero. ")
  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  public PUTScUpdateType ratePlanChargeId(String ratePlanChargeId) {
    this.ratePlanChargeId = ratePlanChargeId;
    return this;
  }

   /**
   * ID of a rate-plan charge for this subscription. 
   * @return ratePlanChargeId
  **/
  @ApiModelProperty(example = "null", required = true, value = "ID of a rate-plan charge for this subscription. ")
  public String getRatePlanChargeId() {
    return ratePlanChargeId;
  }

  public void setRatePlanChargeId(String ratePlanChargeId) {
    this.ratePlanChargeId = ratePlanChargeId;
  }

  public PUTScUpdateType tiers(List<POSTTierType> tiers) {
    this.tiers = tiers;
    return this;
  }

  public PUTScUpdateType addTiersItem(POSTTierType tiersItem) {
    this.tiers.add(tiersItem);
    return this;
  }

   /**
   * Container for Volume, Tiered or Tiered with Overage charge models. Supports the following charge types:  * One-time * Recurring * Usage-based 
   * @return tiers
  **/
  @ApiModelProperty(example = "null", value = "Container for Volume, Tiered or Tiered with Overage charge models. Supports the following charge types:  * One-time * Recurring * Usage-based ")
  public List<POSTTierType> getTiers() {
    return tiers;
  }

  public void setTiers(List<POSTTierType> tiers) {
    this.tiers = tiers;
  }

  public PUTScUpdateType triggerDate(LocalDate triggerDate) {
    this.triggerDate = triggerDate;
    return this;
  }

   /**
   * Specifies when to start billing the customer for the charge. Required if the `triggerEvent` field is set to USD.  `triggerDate` cannot be updated for the following using the REST update subscription call:  * One-time charge type * Discount-Fixed Amount charge model * Discount-Percentage charge model 
   * @return triggerDate
  **/
  @ApiModelProperty(example = "null", value = "Specifies when to start billing the customer for the charge. Required if the `triggerEvent` field is set to USD.  `triggerDate` cannot be updated for the following using the REST update subscription call:  * One-time charge type * Discount-Fixed Amount charge model * Discount-Percentage charge model ")
  public LocalDate getTriggerDate() {
    return triggerDate;
  }

  public void setTriggerDate(LocalDate triggerDate) {
    this.triggerDate = triggerDate;
  }

  public PUTScUpdateType triggerEvent(String triggerEvent) {
    this.triggerEvent = triggerEvent;
    return this;
  }

   /**
   * Specifies when to start billing the customer for the charge.  Values:  * `UCE` * `USA` * `UCA` * `USD`  This is the date when charge changes in the REST request become effective.  `triggerEvent` cannot be updated for the following using the REST update subscription call:  * One-time charge type * Discount-Fixed Amount charge model * Discount-Percentage charge model 
   * @return triggerEvent
  **/
  @ApiModelProperty(example = "null", value = "Specifies when to start billing the customer for the charge.  Values:  * `UCE` * `USA` * `UCA` * `USD`  This is the date when charge changes in the REST request become effective.  `triggerEvent` cannot be updated for the following using the REST update subscription call:  * One-time charge type * Discount-Fixed Amount charge model * Discount-Percentage charge model ")
  public String getTriggerEvent() {
    return triggerEvent;
  }

  public void setTriggerEvent(String triggerEvent) {
    this.triggerEvent = triggerEvent;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PUTScUpdateType pUTScUpdateType = (PUTScUpdateType) o;
    return Objects.equals(this.billingPeriodAlignment, pUTScUpdateType.billingPeriodAlignment) &&
        Objects.equals(this.customFieldC, pUTScUpdateType.customFieldC) &&
        Objects.equals(this.description, pUTScUpdateType.description) &&
        Objects.equals(this.includedUnits, pUTScUpdateType.includedUnits) &&
        Objects.equals(this.overagePrice, pUTScUpdateType.overagePrice) &&
        Objects.equals(this.price, pUTScUpdateType.price) &&
        Objects.equals(this.priceChangeOption, pUTScUpdateType.priceChangeOption) &&
        Objects.equals(this.priceIncreasePercentage, pUTScUpdateType.priceIncreasePercentage) &&
        Objects.equals(this.quantity, pUTScUpdateType.quantity) &&
        Objects.equals(this.ratePlanChargeId, pUTScUpdateType.ratePlanChargeId) &&
        Objects.equals(this.tiers, pUTScUpdateType.tiers) &&
        Objects.equals(this.triggerDate, pUTScUpdateType.triggerDate) &&
        Objects.equals(this.triggerEvent, pUTScUpdateType.triggerEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(billingPeriodAlignment, customFieldC, description, includedUnits, overagePrice, price, priceChangeOption, priceIncreasePercentage, quantity, ratePlanChargeId, tiers, triggerDate, triggerEvent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PUTScUpdateType {\n");
    
    sb.append("    billingPeriodAlignment: ").append(toIndentedString(billingPeriodAlignment)).append("\n");
    sb.append("    customFieldC: ").append(toIndentedString(customFieldC)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    includedUnits: ").append(toIndentedString(includedUnits)).append("\n");
    sb.append("    overagePrice: ").append(toIndentedString(overagePrice)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    priceChangeOption: ").append(toIndentedString(priceChangeOption)).append("\n");
    sb.append("    priceIncreasePercentage: ").append(toIndentedString(priceIncreasePercentage)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    ratePlanChargeId: ").append(toIndentedString(ratePlanChargeId)).append("\n");
    sb.append("    tiers: ").append(toIndentedString(tiers)).append("\n");
    sb.append("    triggerDate: ").append(toIndentedString(triggerDate)).append("\n");
    sb.append("    triggerEvent: ").append(toIndentedString(triggerEvent)).append("\n");
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

