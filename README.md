> [!IMPORTANT]
> This repository has been archived and is no longer maintained.

# SAP PI/PO: Adapter module AddDynamicConfigurationBean
Custom adapter module for Adapter Engine of SAP PI/PO systems to set dynamic configuration attributes of the processed message.

Usage of the adapter module is described in SAP Community blog https://blogs.sap.com/2016/08/23/setting-dynamic-configuration-attributes-using-custom-adapter-module/.


## Adapter module parameterization
|Adapter module parameter|Description|
|---|---|
|class|Name of the class implementing dynamic configuration provider logic. The class is the looked up in subpackage ‘provider’ of the package of the adapter module. If not provided, the default dynamic configuration provider class (DynamicConfigurationProviderDefault) is used.|
|dc.<> / pwd.dc.<> / pwddc.<>|Parameter(s), which value is(are) passed to dynamic configuration provider class as input parameter(s). Note that parameter names shall be prefixed with ‘dc.’ – for example, adapter module parameter ‘dc.code’ will be passed to dynamic configuration provider class as parameter ‘code’ (with omitted prefix). Recognizing possible necessity of providing sensitive parameter values (password like values), the adapter module can also accept parameter names prefixed with 'pwd' (SAP PI/PO standard functionality in adapter modules configuration user interface used to mask input adapter module parameter value in communication channel configuration screen). In this way, prefixes 'pwd.dc.' and 'pwddc.' (depending on your preferences, you can either delimit 'pwd' and 'dc' prefixes with full stop to make them more readable, or write them both in one word) are also valid, same principles of parameter name derivation as for those prefixed with 'dc.' apply – namely, mentioned prefixes will be omitted when passing parameters to dynamic configuration provider class. Adapter module configuration can contain as many these parameters, as required by specific invoked dynamic configuration provider class. Besides parameter prefixes, parameter names and values are not validated by adapter module and are passed to dynamic configuration provider class as is. It is dynamic configuration provider class’s responsibility to handle and make use of them.|
