package com.tuzhi.delivery.util;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.data.simple.SimpleFeatureSource;
import org.opengis.feature.Property;
import org.opengis.feature.simple.SimpleFeature;

/**
 * @author 贺保铭
 *
 * 2018年04月10日
 */
public class ShpUtil {
	public static List<String> readShp(String path){
		List<String> relst = new ArrayList<String>();
		String shpPath = path;
		ShapefileDataStore shpDataStore = null;
		Calendar startTime = Calendar.getInstance();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<String> lsttest = new ArrayList<String>();
		try {
			File file = new File(shpPath);
			shpDataStore = new ShapefileDataStore(file.toURL());
			Charset charset = Charset.forName("GBK");
			shpDataStore.setStringCharset(charset);
			String typeName = shpDataStore.getTypeNames()[0];
			SimpleFeatureSource featureSource = null;
			try {
				/*			System.out.println("typeName="+typeName);as
				File dir = new File("D:\\"+typeName+".shx");

				if (file.exists()) {
					 System.out.println("file exists");
				}*/
				

				featureSource = shpDataStore.getFeatureSource(typeName);

				SimpleFeatureCollection result = featureSource.getFeatures();
				SimpleFeatureIterator itertor = result.features();
				while (itertor.hasNext()) {
					Map<String, Object> data = new HashMap<String, Object>();

					SimpleFeature feature = itertor.next();
					Collection<Property> p = feature.getProperties();
					Iterator<Property> it = p.iterator();
					while (it.hasNext()) {
						Property pro = it.next();
						String field = pro.getName().toString();
						String value = pro.getValue().toString();

						String area="";
						String areadata="";
 
						if(value.indexOf("MULTIPOLYGON")>-1){
							String[] areaArray=value.split(",");
							for(int i=0;i<areaArray.length;i++){

								System.out.println("areaArray[i]="+areaArray[i]);
								area=areaArray[i].replace("MULTIPOLYGON ", "").replaceAll("\\(", "").replaceAll("\\)", "").trim();
								area=area.replaceAll(" ", ",");
								area="["+area+"]";
								areadata+=area;
							}
							areadata="MULTIPOLYGON:"+areadata;
						}else {
							areadata=value.trim();
						}
						System.out.println("areadata="+areadata);

						field = field.equals("the_geom") ? "wkt" : field;
						data.put(field, value);
						lsttest.add(areadata);
					}
					list.add(data);

				}
			} catch (Exception e) {
			}

			String arr[] = lsttest.toString().split(",");
			for (int i = 0; i < arr.length; i++) {
				/*if (i == 0) {//
					String strone = arr[i].substring(16).trim();
					relst.add(strone);
				} else if (i == arr.length - 1) {
					String strend = arr[i].replace(")))", "").trim();
					relst.add(strend);
				} else {
					relst.add(arr[i].trim());
				}*/
				relst.add(arr[i].trim());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return relst;
	}

	public static String readShpJson(String path) {
		
		// 过滤点和面
		String json = readShp(path).toString();

		if (json.indexOf("POINT") > -1) {
			json = json.replaceAll("POINT", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("\\[", "")
					.replaceAll("\\]", "").replaceAll("\"", "");
			json = json.replaceAll(",  ", ",").trim();
		} else if (json.indexOf("MULTIPOLYGON") > -1) { // 调整地图所需要显示格式
			json = json.replace("[[", "").replaceAll("]]", "");
			json = json.replace("][", "],[").replaceAll(" ", "");
			json = json.replace(",MULTIPOLYGON:", "MULTIPOLYGON:");
		}
		
		return json;
	}
	
	public static void main(String[] args) {
		String filePath = "d:\\dian.shp";
		//List<String> relst = readShp(filePath);
		//readShpJson(filePath);
		System.out.println("json ---------  " + readShpJson(filePath));
	}

}
