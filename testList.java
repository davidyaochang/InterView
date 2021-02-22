package ext.test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ext.generic.util.ObjUtil;
import wt.doc.WTDocument;

public class testList {
	public static void main(String[] args) throws Exception {
		List<String> descPartList = new ArrayList<String>();
		descPartList.add("規格書");
		descPartList.add("PDF檔");
		descPartList.add("承認書");
		descPartList.add("PDF檔");
		descPartList.add("承認書");
		descPartList.add("規格書");		
		descPartList.add("PDF檔");
		List<String> uploadDocList = getUploadDocList(descPartList);
		Iterator<String> descPartit = descPartList.iterator();	
		
		for(String value: descPartList) {
			System.out.println(value);
		}
		
		System.out.println();
		
		Iterator<String> it = uploadDocList.iterator();	
		while(it.hasNext()) {
			String temp = it.next().toString();
			System.out.println(temp);
		}		
	}
	
	/*
	 *1.如果有包含承認書就上傳承認書 
	 *2.如果有包含規格書但沒有承認書就上傳規格書
	 *3.*/
	public static List<String> getUploadDocList(List<String> descPartList) throws Exception{
		List<String> list = new ArrayList<String>();
		try {
			Iterator<String> descPartit = descPartList.iterator();
			if(descPartList.contains("承認書")) {
				while(descPartit.hasNext()) {
					String temp = descPartit.next().toString();
					if(temp.equals("承認書")) {
						list.add(temp);
					}					
				}		
			}
			else if(descPartList.contains("規格書")) {
				while(descPartit.hasNext()) {
					String temp = descPartit.next().toString();
					if(temp.equals("規格書")) {
						list.add(temp);
					}					
				}		
			}
			else if(descPartList.contains("PDF檔")) {
				while(descPartit.hasNext()) {
					String temp = descPartit.next().toString();
					if(temp.equals("PDF檔")) {
						list.add(temp);	
					}					
				}		
			}
		} catch (Exception e) {
			System.out.println("***取得上傳檔案清單例外:" + e.getLocalizedMessage());
		}
		return list;
	}

}
