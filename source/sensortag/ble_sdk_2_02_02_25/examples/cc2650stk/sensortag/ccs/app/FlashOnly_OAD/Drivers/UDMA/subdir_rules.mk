################################################################################
# Automatically-generated file. Do not edit!
################################################################################

SHELL = cmd.exe

# Each subdirectory must supply rules for building sources it contributes
Drivers/UDMA/UDMACC26XX.obj: C:/ti/tirtos_cc13xx_cc26xx_2_21_01_08/products/tidrivers_cc13xx_cc26xx_2_21_01_01/packages/ti/drivers/dma/UDMACC26XX.c $(GEN_OPTS) | $(GEN_HDRS)
	@echo 'Building file: $<'
	@echo 'Invoking: ARM Compiler'
	"C:/ti/ccsv7/tools/compiler/ti-cgt-arm_16.9.1.LTS/bin/armcl" --cmd_file="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/examples/cc2650stk/sensortag/ccs/app/../../../../../src/config/build_components.opt" --cmd_file="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/examples/cc2650stk/sensortag/ccs/app/../stack/build_config.opt" --cmd_file="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/examples/cc2650stk/sensortag/ccs/app/../config/ccs_compiler_defines.bcfg"  -mv7M3 --code_state=16 --abi=eabi -me -O4 --opt_for_speed=0 --include_path="C:/ti/ccsv7/tools/compiler/ti-cgt-arm_16.9.1.LTS/include" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/examples/sensortag/cc26xx/app" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/controller/cc26xx/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/rom" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/common/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/icall/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/profiles/batt/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/profiles/dev_info" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/profiles/hid_dev/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/profiles/keys" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/profiles/oad/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/profiles/roles" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/profiles/roles/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/profiles/sensor_profile/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/heapmgr" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target/_common/cc26xx" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/hal/src/target/_common" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/target" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/icall/src" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/icall/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/osal/src/inc" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/saddr" --include_path="C:/Users/Elis/Desktop/HIS/SOSE2018/SSNS/Project/Source_Code/SSNS/SSNS/source/sensortag/ble_sdk_2_02_02_25/src/components/services/src/sdata" --include_path="C:/ti/tirtos_cc13xx_cc26xx_2_21_01_08/products/cc26xxware_2_24_03_17272" --include_path="C:/ti/tirtos_cc13xx_cc26xx_2_21_01_08/products/tidrivers_cc13xx_cc26xx_2_21_01_01/packages" --include_path="C:/ti/tirtos_cc13xx_cc26xx_2_21_01_08/products/tidrivers_cc13xx_cc26xx_2_21_01_01/packages/ti/mw/extflash" --include_path="C:/ti/tirtos_cc13xx_cc26xx_2_21_01_08/products/tidrivers_cc13xx_cc26xx_2_21_01_01/packages/ti/mw/sensors" --include_path="C:/ti/tirtos_cc13xx_cc26xx_2_21_01_08/products/tidrivers_cc13xx_cc26xx_2_21_01_01/packages/ti/mw/sensortag" --c99 --define=EXCLUDE_OAD --define=Board_BUZZER --define=EXCLUDE_OPT --define=EXCLUDE_BAR --define=EXCLUDE_HUM --define=EXCLUDE_TMP --define=CC2650STK --define=CC26XX --define=Display_DISABLE_ALL --define=EXCLUDE_AUDIO --define=FACTORY_IMAGE --define=FEATURE_OAD --define=GAPROLE_TASK_STACK_SIZE=600 --define=GATT_TI_UUID_128_BIT --define=HEAPMGR_SIZE=0 --define=ICALL_MAX_NUM_ENTITIES=11 --define=ICALL_MAX_NUM_TASKS=8 --define=POWER_SAVING --define=ST_TASK_STACK_SIZE=848 --define=USE_ICALL --define=xdc_runtime_Assert_DISABLE_ALL --define=xdc_runtime_Log_DISABLE_ALL --diag_warning=225 --display_error_number --diag_suppress=48 --diag_wrap=off --gen_func_subsections=on --preproc_with_compile --preproc_dependency="Drivers/UDMA/UDMACC26XX.d" --obj_directory="Drivers/UDMA" $(GEN_OPTS__FLAG) "$<"
	@echo 'Finished building: $<'
	@echo ' '


