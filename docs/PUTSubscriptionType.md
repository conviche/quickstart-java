
# PUTSubscriptionType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**cpqBundleJsonIdQT** | **String** |  |  [optional]
**opportunityCloseDateQT** | **String** | The closing date of the Opportunity. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information.  |  [optional]
**opportunityNameQT** | **String** | The unique identifier of the Opportunity. This field is populated when the subscription originates from Zuora Quotes.  This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information.  |  [optional]
**quoteBusinessTypeQT** | **String** | The specific identifier for the type of business transaction the Quote represents such as &#x60;New&#x60;, &#x60;Upsell&#x60;, &#x60;Downsell&#x60;, &#x60;Renewal&#x60;, or &#x60;Churn&#x60;. This field is populated when the subscription originates from Zuora Quotes.            This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information.  |  [optional]
**quoteNumberQT** | **String** | The unique identifier of the Quote. This field is populated when the subscription originates from Zuora Quotes.            This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information.  |  [optional]
**quoteTypeQT** | **String** | The Quote type that represents the subscription lifecycle stage such as &#x60;New&#x60;, &#x60;Amendment&#x60;, &#x60;Renew&#x60;, or &#x60;Cancel&#x60;. This field is populated when the subscription originates from Zuora Quotes.            This field is used only for reporting subscription metrics.   See [Subscription Data Source](https://knowledgecenter.zuora.com/CD_Reporting/Data_Exports/Z_Data_Source_Reference/Subscription_Data_Source) for more information.  |  [optional]
**add** | [**List&lt;PUTSrpAddType&gt;**](PUTSrpAddType.md) | Container for adding one or more rate plans.  |  [optional]
**applyCreditBalance** | **Boolean** | Applies a credit balance to an invoice.  If the value is &#x60;true&#x60;, the credit balance is applied to the invoice. If the value is &#x60;false&#x60;, no action is taken.  **Prerequisite:** &#x60;invoice&#x60; must be true.   **Note:** If you are using the field &#x60;invoiceCollect&#x60; rather than the field &#x60;invoice&#x60;, the &#x60;invoiceCollect&#x60; value must be true.  To view the credit balance adjustment, retrieve the details of the invoice using the Get Invoices method.  |  [optional]
**autoRenew** | **Boolean** | If &#x60;true&#x60;, this subscription automatically renews at the end of the subscription term. Default is &#x60;false&#x60;.  |  [optional]
**currentTerm** | **Long** | The length of the period for the current subscription term. If &#x60;termType&#x60; is &#x60;TERMED&#x60;, this field is required and must be greater than &#x60;0&#x60;. If &#x60;termType&#x60; is &#x60;EVERGREEN&#x60;, this value is ignored. Default is &#x60;0&#x60;.  |  [optional]
**currentTermPeriodType** | **String** | The period type for the current subscription term.  This field is used with the &#x60;CurrentTerm&#x60; field to specify the current subscription term.  Values are:  * &#x60;Month&#x60; (default) * &#x60;Year&#x60; * &#x60;Day&#x60; * &#x60;Week&#x60;  |  [optional]
**customFieldC** | **String** | Any custom fields defined for this object.  |  [optional]
**includeExistingDraftInvoiceItems** | **Boolean** | Specifies whether to include draft invoice items in amendment previews.  Values:   * &#x60;true&#x60; (default). Includes draft invoice items in amendment previews.  * &#x60;false&#x60;. Excludes draft invoice items in amendment previews.  |  [optional]
**invoice** | **Boolean** | Creates an invoice for a subscription. The invoice generated in this operation is only for this subscription, not for the entire customer account.  If the value is &#x60;true&#x60;, an invoice is created. If the value is &#x60;false&#x60;, no action is taken.  The default value is &#x60;false&#x60;.   This field is in Zuora REST API version control. Supported minor versions are 196.0 or later. To use this field in the method, you must set the &#x60;zuora-version&#x60; parameter to the minor version number in the request header. See [Zuora REST API Versions](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics#Zuora_REST_API_Versions) for more information.  |  [optional]
**invoiceCollect** | **Boolean** | **Note:** This field has been replaced by the &#x60;invoice&#x60; field and the &#x60;collect&#x60; field. &#x60;invoiceCollect&#x60; is available only for backward compatibility.  If &#x60;true&#x60;, an invoice is generated and payment collected automatically during the subscription process. If &#x60;false&#x60; (default), no invoicing or payment takes place.  The invoice generated in this operation is only for this subscription, not for the entire customer account.  This field is in Zuora REST API version control. Supported minor versions are 186.0, 187.0, 188.0, 189.0, and 196.0. See [Zuora REST API Versions](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics#Zuora_REST_API_Versions) for more information.  |  [optional]
**invoiceSeparately** | **Boolean** | Separates a single subscription from other subscriptions and invoices the charge independently.   If the value is &#x60;true&#x60;, the subscription is billed separately from other subscriptions. If the value is &#x60;false&#x60;, the subscription is included with other subscriptions in the account invoice.  The default value is &#x60;false&#x60;. Prerequisite: The default subscription setting Enable Subscriptions to be Invoiced Separately must be set to Yes.  |  [optional]
**invoiceTargetDate** | [**LocalDate**](LocalDate.md) | Date through which to calculate charges if an invoice is generated, as yyyy-mm-dd. Default is current date.  |  [optional]
**notes** | **String** | String of up to 500 characters.  |  [optional]
**preview** | **Boolean** | If &#x60;true&#x60; the update is made in preview mode. The default setting is &#x60;false&#x60;.  |  [optional]
**previewType** | **String** |  The type of preview you will receive. The possible values are &#x60;InvoiceItem&#x60;, &#x60;ChargeMetrics&#x60;, or &#x60;InvoiceItemChargeMetrics&#x60;. The default is &#x60;InvoiceItem&#x60;.  |  [optional]
**remove** | [**List&lt;PUTSrpRemoveType&gt;**](PUTSrpRemoveType.md) | Container for removing one or more rate plans.  |  [optional]
**renewalSetting** | **String** | Specifies whether a termed subscription will remain &#x60;TERMED&#x60; or change to &#x60;EVERGREEN&#x60; when it is renewed.   Values are:  * &#x60;RENEW_WITH_SPECIFIC_TERM&#x60; (default) * &#x60;RENEW_TO_EVERGREEN&#x60;  |  [optional]
**renewalTerm** | **Long** | The length of the period for the subscription renewal term. Default is &#x60;0&#x60;.  |  [optional]
**renewalTermPeriodType** | **String** |  The period type for the subscription renewal term.  This field is used with the &#x60;renewalTerm&#x60; field to specify the subscription renewal term.  Values are:  * &#x60;Month&#x60; (default) * &#x60;Year&#x60; * &#x60;Day&#x60; * &#x60;Week&#x60;  |  [optional]
**termStartDate** | [**LocalDate**](LocalDate.md) | Date the subscription term begins, as yyyy-mm-dd. If this is a renewal subscription, this date is different from the subscription start date.   |  [optional]
**termType** | **String** | Possible values are: &#x60;TERMED&#x60;, &#x60;EVERGREEN&#x60;.  |  [optional]
**update** | [**List&lt;PUTSrpUpdateType&gt;**](PUTSrpUpdateType.md) | Container for updating one or more rate plans.  |  [optional]


