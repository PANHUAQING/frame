package com.phq.frame.util.file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * 
 * @ClassName: FileUploadUtil
 * @Description: 文件上传及下载工具类
 * @author: panhuaqing
 * @date: 2019年4月1日 下午3:41:39
 * @Copyright:
 */
public class FileUploadUtil {
	/**
	 * 
	 * @Title: uploadFiles   
	 * @Description: 
	 *     文件上传  
	 * @param: @param request
	 * @param: @param rootPath      
	 * @return: void      
	 * @throws
	 */
	public static void uploadFiles(HttpServletRequest request, String rootPath) {
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		List<MultipartFile> files = (List<MultipartFile>) multipartHttpServletRequest.getFiles("file");
		MultipartFile file = null;
		BufferedOutputStream stream = null;
		
		for (int i = 0; i < files.size(); ++i) {
			file = files.get(i);
			if (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();
					File filesName = mkDir(rootPath+file.getOriginalFilename());
					stream = new BufferedOutputStream(new FileOutputStream(filesName));
					
					stream.write(bytes);
				} catch (Exception e) {
					System.out.println("上传失败！！");
					break;
				}finally {
					try {
						stream.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			} else {
				System.out.println("文件为空！！");
			}
		}

	}

	/**
	 * 功能描述：判断目录是否存在，如果不存在则创建 
	 * 适用范围：公用
	 * @param path
	 *            目录
	 */
	public static File mkDir(String path) {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		return file;
	}

	/**
	 * 根据路径删除指定的目录或文件，无论存在与否
	 * 
	 * @param sPath
	 *            要删除的目录或文件
	 * @return 删除成功返回 true，否则返回 false。
	 */
	public static boolean deleteFolder(String sPath) {
		boolean flag = false;
		File file = new File(sPath);
		// 判断目录或文件是否存在
		if (!file.exists()) { // 不存在返回 false
			return flag;
		} else {
			// 判断是否为文件
			if (file.isFile()) { // 为文件时调用删除文件方法
				return deleteFile(sPath);
			} else { // 为目录时调用删除目录方法
				return deleteDirectory(sPath);
			}
		}
	}

	/**
	 * 删除单个文件
	 * 
	 * @param sPath
	 *            被删除文件的文件名
	 * @return 单个文件删除成功返回true，否则返回false
	 */
	public static boolean deleteFile(String sPath) {
		boolean flag = false;
		File file = new File(sPath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = true;
		}
		return flag;
	}

	/**
	 * 删除目录（文件夹）以及目录下的文件
	 * 
	 * @param sPath
	 *            被删除目录的文件路径
	 * @return 目录删除成功返回true，否则返回false
	 */
	public static boolean deleteDirectory(String sPath) {

		// 如果sPath不以文件分隔符结尾，自动添加文件分隔符
		if (!sPath.endsWith(File.separator)) {
			sPath = sPath + File.separator;
		}
		File dirFile = new File(sPath);
		// 如果dir对应的文件不存在，或者不是一个目录，则退出
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			return false;
		}
		boolean flag = true;
		// 删除文件夹下的所有文件(包括子目录)
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			// 删除子文件
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag)
					break;
			} // 删除子目录
			else {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag)
					break;
			}
		}
		if (!flag)
			return false;
		// 删除当前目录
		if (dirFile.delete()) {
			return true;
		} else {
			return false;
		}
	}

}
