# invoke SourceDir generated makefile for app_ble.pem3
app_ble.pem3: .libraries,app_ble.pem3
.libraries,app_ble.pem3: package/cfg/app_ble_pem3.xdl
	$(MAKE) -f D:\SSNS\source\sensortag\ble_sdk_2_02_02_25\examples\cc2650stk\sensortag\ccs\config/src/makefile.libs

clean::
	$(MAKE) -f D:\SSNS\source\sensortag\ble_sdk_2_02_02_25\examples\cc2650stk\sensortag\ccs\config/src/makefile.libs clean

