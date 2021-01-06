package tech.tongyu.core.utils;

import tech.tongyu.core.exceptions.CustomCommonException;
import tech.tongyu.core.exceptions.CustomErrorMessage;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description shell调用
 **/
public class ShellUtils {

    public static int ExecCommand(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            return process.waitFor();
        } catch (Exception e) {
            throw new CustomCommonException(CustomErrorMessage.Errors.SHELL_EXECUTE_ERROR, e.getMessage());
        }
    }
}
