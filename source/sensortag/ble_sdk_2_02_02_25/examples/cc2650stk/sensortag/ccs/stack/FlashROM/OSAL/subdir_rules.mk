################################################################################
# Automatically-generated file. Do not edit!
################################################################################

SHELL = cmd.exe

# Each subdirectory must supply rules for building sources it contributes
OSAL/osal.obj: C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/osal/src/common/osal.c $(GEN_OPTS) | $(GEN_HDRS)
	@echo 'Building file: $<'
	@echo 'Invoking: ARM Compiler'
	"C:/ti/ccsv7/tools/compiler/ti-cgt-arm_16.9.1.LTS/bin/armcl" --cmd_file="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/examples/cc2650stk/sensortag/ccs/stack/../../../../../src/config/build_components.opt" --cmd_file="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/examples/cc2650stk/sensortag/ccs/stack/build_config.opt"  -mv7M3 --code_state=16 --abi=eabi -me -O4 --opt_for_speed=0 --include_path="C:/ti/ccsv7/tools/compiler/ti-cgt-arm_16.9.1.LTS/include" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/examples/sensortag/cc26xx/stack" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/common/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target/_common" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target/_common" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target/_common/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/osal/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/saddr" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/nv/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/nv" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/icall/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/rom" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/controller/cc26xx/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/aes/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/npi/src" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/common/cc26xx/npi/stack" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/icall/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/profiles/roles" --include_path="C:/ti/tirtos_cc13xx_cc26xx_2_21_01_08/products/cc26xxware_2_24_03_17272" --c99 --define=CC26XX --define=CC26XXWARE --define=DATA= --define=EXT_HAL_ASSERT --define=FLASH_ROM_BUILD --define=GATT_NO_CLIENT --define=INCLUDE_AES_DECRYPT --define=NEAR_FUNC= --define=OSAL_CBTIMER_NUM_TASKS=1 --define=OSAL_MAX_NUM_PROXY_TASKS=8 --define=OSAL_SNV=0 --define=POWER_SAVING --define=USE_ICALL --define=xDEBUG --define=xDEBUG_ENC --define=xDEBUG_GPIO --define=xDEBUG_SW_TRACE --define=xNO_BLE_SECURITY --define=xPM_DISABLE_PWRDOWN --define=xTESTMODES --define=xTEST_BLEBOARD --diag_warning=225 --display_error_number --diag_suppress=48 --diag_suppress=16004 --diag_wrap=off --preproc_with_compile --preproc_dependency="OSAL/osal.d" --obj_directory="OSAL" $(GEN_OPTS__FLAG) "$<"
	@echo 'Finished building: $<'
	@echo ' '

OSAL/osal_bufmgr.obj: C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/osal/src/common/osal_bufmgr.c $(GEN_OPTS) | $(GEN_HDRS)
	@echo 'Building file: $<'
	@echo 'Invoking: ARM Compiler'
	"C:/ti/ccsv7/tools/compiler/ti-cgt-arm_16.9.1.LTS/bin/armcl" --cmd_file="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/examples/cc2650stk/sensortag/ccs/stack/../../../../../src/config/build_components.opt" --cmd_file="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/examples/cc2650stk/sensortag/ccs/stack/build_config.opt"  -mv7M3 --code_state=16 --abi=eabi -me -O4 --opt_for_speed=0 --include_path="C:/ti/ccsv7/tools/compiler/ti-cgt-arm_16.9.1.LTS/include" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/examples/sensortag/cc26xx/stack" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/common/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target/_common" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target/_common" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target/_common/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/osal/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/saddr" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/nv/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/nv" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/icall/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/rom" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/controller/cc26xx/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/aes/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/npi/src" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/common/cc26xx/npi/stack" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/icall/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/profiles/roles" --include_path="C:/ti/tirtos_cc13xx_cc26xx_2_21_01_08/products/cc26xxware_2_24_03_17272" --c99 --define=CC26XX --define=CC26XXWARE --define=DATA= --define=EXT_HAL_ASSERT --define=FLASH_ROM_BUILD --define=GATT_NO_CLIENT --define=INCLUDE_AES_DECRYPT --define=NEAR_FUNC= --define=OSAL_CBTIMER_NUM_TASKS=1 --define=OSAL_MAX_NUM_PROXY_TASKS=8 --define=OSAL_SNV=0 --define=POWER_SAVING --define=USE_ICALL --define=xDEBUG --define=xDEBUG_ENC --define=xDEBUG_GPIO --define=xDEBUG_SW_TRACE --define=xNO_BLE_SECURITY --define=xPM_DISABLE_PWRDOWN --define=xTESTMODES --define=xTEST_BLEBOARD --diag_warning=225 --display_error_number --diag_suppress=48 --diag_suppress=16004 --diag_wrap=off --preproc_with_compile --preproc_dependency="OSAL/osal_bufmgr.d" --obj_directory="OSAL" $(GEN_OPTS__FLAG) "$<"
	@echo 'Finished building: $<'
	@echo ' '

OSAL/osal_cbtimer.obj: C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/osal/src/common/osal_cbtimer.c $(GEN_OPTS) | $(GEN_HDRS)
	@echo 'Building file: $<'
	@echo 'Invoking: ARM Compiler'
	"C:/ti/ccsv7/tools/compiler/ti-cgt-arm_16.9.1.LTS/bin/armcl" --cmd_file="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/examples/cc2650stk/sensortag/ccs/stack/../../../../../src/config/build_components.opt" --cmd_file="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/examples/cc2650stk/sensortag/ccs/stack/build_config.opt"  -mv7M3 --code_state=16 --abi=eabi -me -O4 --opt_for_speed=0 --include_path="C:/ti/ccsv7/tools/compiler/ti-cgt-arm_16.9.1.LTS/include" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/examples/sensortag/cc26xx/stack" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/common/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target/_common" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target/_common" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target/_common/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/osal/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/saddr" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/nv/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/nv" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/icall/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/rom" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/controller/cc26xx/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/aes/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/npi/src" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/common/cc26xx/npi/stack" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/icall/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/profiles/roles" --include_path="C:/ti/tirtos_cc13xx_cc26xx_2_21_01_08/products/cc26xxware_2_24_03_17272" --c99 --define=CC26XX --define=CC26XXWARE --define=DATA= --define=EXT_HAL_ASSERT --define=FLASH_ROM_BUILD --define=GATT_NO_CLIENT --define=INCLUDE_AES_DECRYPT --define=NEAR_FUNC= --define=OSAL_CBTIMER_NUM_TASKS=1 --define=OSAL_MAX_NUM_PROXY_TASKS=8 --define=OSAL_SNV=0 --define=POWER_SAVING --define=USE_ICALL --define=xDEBUG --define=xDEBUG_ENC --define=xDEBUG_GPIO --define=xDEBUG_SW_TRACE --define=xNO_BLE_SECURITY --define=xPM_DISABLE_PWRDOWN --define=xTESTMODES --define=xTEST_BLEBOARD --diag_warning=225 --display_error_number --diag_suppress=48 --diag_suppress=16004 --diag_wrap=off --preproc_with_compile --preproc_dependency="OSAL/osal_cbtimer.d" --obj_directory="OSAL" $(GEN_OPTS__FLAG) "$<"
	@echo 'Finished building: $<'
	@echo ' '

OSAL/osal_clock.obj: C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/osal/src/common/osal_clock.c $(GEN_OPTS) | $(GEN_HDRS)
	@echo 'Building file: $<'
	@echo 'Invoking: ARM Compiler'
	"C:/ti/ccsv7/tools/compiler/ti-cgt-arm_16.9.1.LTS/bin/armcl" --cmd_file="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/examples/cc2650stk/sensortag/ccs/stack/../../../../../src/config/build_components.opt" --cmd_file="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/examples/cc2650stk/sensortag/ccs/stack/build_config.opt"  -mv7M3 --code_state=16 --abi=eabi -me -O4 --opt_for_speed=0 --include_path="C:/ti/ccsv7/tools/compiler/ti-cgt-arm_16.9.1.LTS/include" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/examples/sensortag/cc26xx/stack" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/common/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target/_common" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target/_common" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target/_common/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/osal/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/saddr" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/nv/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/nv" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/icall/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/rom" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/controller/cc26xx/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/aes/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/npi/src" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/common/cc26xx/npi/stack" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/icall/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/profiles/roles" --include_path="C:/ti/tirtos_cc13xx_cc26xx_2_21_01_08/products/cc26xxware_2_24_03_17272" --c99 --define=CC26XX --define=CC26XXWARE --define=DATA= --define=EXT_HAL_ASSERT --define=FLASH_ROM_BUILD --define=GATT_NO_CLIENT --define=INCLUDE_AES_DECRYPT --define=NEAR_FUNC= --define=OSAL_CBTIMER_NUM_TASKS=1 --define=OSAL_MAX_NUM_PROXY_TASKS=8 --define=OSAL_SNV=0 --define=POWER_SAVING --define=USE_ICALL --define=xDEBUG --define=xDEBUG_ENC --define=xDEBUG_GPIO --define=xDEBUG_SW_TRACE --define=xNO_BLE_SECURITY --define=xPM_DISABLE_PWRDOWN --define=xTESTMODES --define=xTEST_BLEBOARD --diag_warning=225 --display_error_number --diag_suppress=48 --diag_suppress=16004 --diag_wrap=off --preproc_with_compile --preproc_dependency="OSAL/osal_clock.d" --obj_directory="OSAL" $(GEN_OPTS__FLAG) "$<"
	@echo 'Finished building: $<'
	@echo ' '

OSAL/osal_memory_icall.obj: C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/osal/src/common/osal_memory_icall.c $(GEN_OPTS) | $(GEN_HDRS)
	@echo 'Building file: $<'
	@echo 'Invoking: ARM Compiler'
	"C:/ti/ccsv7/tools/compiler/ti-cgt-arm_16.9.1.LTS/bin/armcl" --cmd_file="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/examples/cc2650stk/sensortag/ccs/stack/../../../../../src/config/build_components.opt" --cmd_file="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/examples/cc2650stk/sensortag/ccs/stack/build_config.opt"  -mv7M3 --code_state=16 --abi=eabi -me -O4 --opt_for_speed=0 --include_path="C:/ti/ccsv7/tools/compiler/ti-cgt-arm_16.9.1.LTS/include" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/examples/sensortag/cc26xx/stack" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/common/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target/_common" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target/_common" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target/_common/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/osal/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/saddr" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/nv/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/nv" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/icall/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/rom" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/controller/cc26xx/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/aes/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/npi/src" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/common/cc26xx/npi/stack" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/icall/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/profiles/roles" --include_path="C:/ti/tirtos_cc13xx_cc26xx_2_21_01_08/products/cc26xxware_2_24_03_17272" --c99 --define=CC26XX --define=CC26XXWARE --define=DATA= --define=EXT_HAL_ASSERT --define=FLASH_ROM_BUILD --define=GATT_NO_CLIENT --define=INCLUDE_AES_DECRYPT --define=NEAR_FUNC= --define=OSAL_CBTIMER_NUM_TASKS=1 --define=OSAL_MAX_NUM_PROXY_TASKS=8 --define=OSAL_SNV=0 --define=POWER_SAVING --define=USE_ICALL --define=xDEBUG --define=xDEBUG_ENC --define=xDEBUG_GPIO --define=xDEBUG_SW_TRACE --define=xNO_BLE_SECURITY --define=xPM_DISABLE_PWRDOWN --define=xTESTMODES --define=xTEST_BLEBOARD --diag_warning=225 --display_error_number --diag_suppress=48 --diag_suppress=16004 --diag_wrap=off --preproc_with_compile --preproc_dependency="OSAL/osal_memory_icall.d" --obj_directory="OSAL" $(GEN_OPTS__FLAG) "$<"
	@echo 'Finished building: $<'
	@echo ' '

OSAL/osal_pwrmgr.obj: C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/osal/src/common/osal_pwrmgr.c $(GEN_OPTS) | $(GEN_HDRS)
	@echo 'Building file: $<'
	@echo 'Invoking: ARM Compiler'
	"C:/ti/ccsv7/tools/compiler/ti-cgt-arm_16.9.1.LTS/bin/armcl" --cmd_file="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/examples/cc2650stk/sensortag/ccs/stack/../../../../../src/config/build_components.opt" --cmd_file="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/examples/cc2650stk/sensortag/ccs/stack/build_config.opt"  -mv7M3 --code_state=16 --abi=eabi -me -O4 --opt_for_speed=0 --include_path="C:/ti/ccsv7/tools/compiler/ti-cgt-arm_16.9.1.LTS/include" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/examples/sensortag/cc26xx/stack" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/common/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target/_common" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target/_common" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target/_common/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/osal/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/saddr" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/nv/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/nv" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/icall/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/rom" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/controller/cc26xx/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/aes/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/npi/src" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/common/cc26xx/npi/stack" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/icall/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/profiles/roles" --include_path="C:/ti/tirtos_cc13xx_cc26xx_2_21_01_08/products/cc26xxware_2_24_03_17272" --c99 --define=CC26XX --define=CC26XXWARE --define=DATA= --define=EXT_HAL_ASSERT --define=FLASH_ROM_BUILD --define=GATT_NO_CLIENT --define=INCLUDE_AES_DECRYPT --define=NEAR_FUNC= --define=OSAL_CBTIMER_NUM_TASKS=1 --define=OSAL_MAX_NUM_PROXY_TASKS=8 --define=OSAL_SNV=0 --define=POWER_SAVING --define=USE_ICALL --define=xDEBUG --define=xDEBUG_ENC --define=xDEBUG_GPIO --define=xDEBUG_SW_TRACE --define=xNO_BLE_SECURITY --define=xPM_DISABLE_PWRDOWN --define=xTESTMODES --define=xTEST_BLEBOARD --diag_warning=225 --display_error_number --diag_suppress=48 --diag_suppress=16004 --diag_wrap=off --preproc_with_compile --preproc_dependency="OSAL/osal_pwrmgr.d" --obj_directory="OSAL" $(GEN_OPTS__FLAG) "$<"
	@echo 'Finished building: $<'
	@echo ' '

OSAL/osal_snv_wrapper.obj: C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/osal/src/mcu/cc26xx/osal_snv_wrapper.c $(GEN_OPTS) | $(GEN_HDRS)
	@echo 'Building file: $<'
	@echo 'Invoking: ARM Compiler'
	"C:/ti/ccsv7/tools/compiler/ti-cgt-arm_16.9.1.LTS/bin/armcl" --cmd_file="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/examples/cc2650stk/sensortag/ccs/stack/../../../../../src/config/build_components.opt" --cmd_file="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/examples/cc2650stk/sensortag/ccs/stack/build_config.opt"  -mv7M3 --code_state=16 --abi=eabi -me -O4 --opt_for_speed=0 --include_path="C:/ti/ccsv7/tools/compiler/ti-cgt-arm_16.9.1.LTS/include" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/examples/sensortag/cc26xx/stack" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/common/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target/_common" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target/_common" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target/_common/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/osal/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/saddr" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/nv/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/nv" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/icall/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/rom" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/controller/cc26xx/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/aes/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/npi/src" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/common/cc26xx/npi/stack" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/icall/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/profiles/roles" --include_path="C:/ti/tirtos_cc13xx_cc26xx_2_21_01_08/products/cc26xxware_2_24_03_17272" --c99 --define=CC26XX --define=CC26XXWARE --define=DATA= --define=EXT_HAL_ASSERT --define=FLASH_ROM_BUILD --define=GATT_NO_CLIENT --define=INCLUDE_AES_DECRYPT --define=NEAR_FUNC= --define=OSAL_CBTIMER_NUM_TASKS=1 --define=OSAL_MAX_NUM_PROXY_TASKS=8 --define=OSAL_SNV=0 --define=POWER_SAVING --define=USE_ICALL --define=xDEBUG --define=xDEBUG_ENC --define=xDEBUG_GPIO --define=xDEBUG_SW_TRACE --define=xNO_BLE_SECURITY --define=xPM_DISABLE_PWRDOWN --define=xTESTMODES --define=xTEST_BLEBOARD --diag_warning=225 --display_error_number --diag_suppress=48 --diag_suppress=16004 --diag_wrap=off --preproc_with_compile --preproc_dependency="OSAL/osal_snv_wrapper.d" --obj_directory="OSAL" $(GEN_OPTS__FLAG) "$<"
	@echo 'Finished building: $<'
	@echo ' '

OSAL/osal_timers.obj: C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/osal/src/common/osal_timers.c $(GEN_OPTS) | $(GEN_HDRS)
	@echo 'Building file: $<'
	@echo 'Invoking: ARM Compiler'
	"C:/ti/ccsv7/tools/compiler/ti-cgt-arm_16.9.1.LTS/bin/armcl" --cmd_file="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/examples/cc2650stk/sensortag/ccs/stack/../../../../../src/config/build_components.opt" --cmd_file="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/examples/cc2650stk/sensortag/ccs/stack/build_config.opt"  -mv7M3 --code_state=16 --abi=eabi -me -O4 --opt_for_speed=0 --include_path="C:/ti/ccsv7/tools/compiler/ti-cgt-arm_16.9.1.LTS/include" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/examples/sensortag/cc26xx/stack" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/common/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target/_common" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target/_common" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target/_common/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/osal/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/saddr" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/nv/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/nv" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/icall/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/rom" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/controller/cc26xx/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/aes/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/npi/src" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/common/cc26xx/npi/stack" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/icall/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/profiles/roles" --include_path="C:/ti/tirtos_cc13xx_cc26xx_2_21_01_08/products/cc26xxware_2_24_03_17272" --c99 --define=CC26XX --define=CC26XXWARE --define=DATA= --define=EXT_HAL_ASSERT --define=FLASH_ROM_BUILD --define=GATT_NO_CLIENT --define=INCLUDE_AES_DECRYPT --define=NEAR_FUNC= --define=OSAL_CBTIMER_NUM_TASKS=1 --define=OSAL_MAX_NUM_PROXY_TASKS=8 --define=OSAL_SNV=0 --define=POWER_SAVING --define=USE_ICALL --define=xDEBUG --define=xDEBUG_ENC --define=xDEBUG_GPIO --define=xDEBUG_SW_TRACE --define=xNO_BLE_SECURITY --define=xPM_DISABLE_PWRDOWN --define=xTESTMODES --define=xTEST_BLEBOARD --diag_warning=225 --display_error_number --diag_suppress=48 --diag_suppress=16004 --diag_wrap=off --preproc_with_compile --preproc_dependency="OSAL/osal_timers.d" --obj_directory="OSAL" $(GEN_OPTS__FLAG) "$<"
	@echo 'Finished building: $<'
	@echo ' '


