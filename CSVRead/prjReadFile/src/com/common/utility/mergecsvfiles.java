package com.common.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.Iterator;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;

import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFCell;


//Import files Required for Csv to Csv format
import au.com.bytecode.opencsv.CSVReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import com.opencsv.CSVWriter;



public class mergecsvfiles {
	Map<String,String> dictionary = null;
	@SuppressWarnings("resource")
	public void MergeCSV() throws Exception{
		CSVReader csvReader = null;
		
		//File filedir = new File(".");
		
		
		
		String csvFile = "E:\\Projects\\Sunil\\Data\\empfile1.csv";
		String csvFile1 = "E:\\Projects\\Sunil\\Data\\empfile2.csv";
		try {			
			csvReader = new CSVReader(new FileReader(csvFile));			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error occured while executing file. "
					+ e.getMessage());
		}
		
		ArrayList<String[]> items = new ArrayList<String[]>();
		String[] headerRow = csvReader.readNext();
		
		if (null == headerRow) {
			throw new FileNotFoundException(
					"No columns defined in given CSV file." +
					"Please check the CSV file format.");
		}
		//Create Dictionary
		/*dictionary = new HashMap<String,String>();
		dictionary.put("Order ID", "PO");
		dictionary.put("Ship Date", "SHIP_DATE");
		dictionary.put("Item Shipped", "ITEM_SHIPPED");
		dictionary.put("Item Ordered", "CATALOG");
		dictionary.put("Quantity Shipped", "QTY_SHIPPED");*/
		
		
		items.add(headerRow);
		String[] nextLine;
		nextLine = csvReader.readNext();
		
		while (nextLine != null) {
			items.add(nextLine);
			nextLine = csvReader.readNext(); 			
		}
		
		
		try {			
			csvReader = new CSVReader(new FileReader(csvFile1));			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error occured while executing file. "
					+ e.getMessage());
		}
		
		nextLine = csvReader.readNext();
		
		while (nextLine != null) {
			items.add(nextLine);
			nextLine = csvReader.readNext(); 			
		}
		
		
		/*
		String pos ="";
		String[] posarray = null;
		//Do formatting
		int i  = 0, j = 0, k = 0  ;
		String[] dataarray = null;
		ArrayList<String[]> newitems = new ArrayList<String[]>();
		String dateval = "";
		for(String[] item : items){
			dataarray = new String[5];
			if(i == 0){
				
				for(String itemval : item){
					if(dictionary.containsKey(itemval)){
						pos = pos + j + ",";
						dataarray[k++] = String.valueOf(dictionary.get(itemval)) ;
					}
					j++;
				}
				posarray = pos.split(",");
				
			}
			else{
				
				
				for(int ii = 0 ; ii < posarray.length ; ii++){
					int val = 0;
					val = Integer.parseInt(posarray[ii]);
					if(ii == 1){
						dateval = item[val].split(" ")[0];
						dataarray[k++] = dateval;
					}
					else{
						dataarray[k++] = item[val];
					}
					
				}
				
			}
			String ival = dataarray[2];
			dataarray[2] = dataarray[3];
			dataarray[3] = ival;
			
			//dataarray[1] = dataarray.
			
			newitems.add(dataarray);
			i++;	
			k =0;
		}*/
		String csv = "E:\\Projects\\Sunil\\Data\\finalempfile.csv";
		
		CSVWriter writer = new CSVWriter(new FileWriter(csv));
		writer.writeAll(items);
		writer.close();
	}
}
