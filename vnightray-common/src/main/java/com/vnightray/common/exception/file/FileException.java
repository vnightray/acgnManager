/**
 * @author vnightray
 * date 2022-06-01
 * author vessa
 * project_name springbootvue
 */
package com.vnightray.common.exception.file;

import com.vnightray.common.exception.BaseException;

/**
 * 文件信息异常类
 */
public class FileException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args)
    {
        super("file", code, args, null);
    }

}
