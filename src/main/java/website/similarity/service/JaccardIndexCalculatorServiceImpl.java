package website.similarity.service;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

@Service
public class JaccardIndexCalculatorServiceImpl implements JaccardIndexCalculatorService{

	private static final Logger LOGGER = Logger.getLogger(JaccardIndexCalculatorServiceImpl.class.getName());
	
	@Override
	public Double calculateJaccardIndex(String text1, String text2) {

		LOGGER.info("Initiated Jaccard index calculation");
			
		Set<String> setA = convertTextToStringsSet(text1);
		Set<String> setB = convertTextToStringsSet(text2);
		Double setACount = Double.valueOf(setA.size());
		Double setBCount = Double.valueOf(setB.size());
		setA.retainAll(setB);
		Double setAIntersectionBCount = Double.valueOf(setA.size());
		
		return setAIntersectionBCount/(setACount + setBCount - setAIntersectionBCount);

	}
	
	public static Set<String> convertTextToStringsSet(String text){
		
		Set<String> resultStringSet = new HashSet<String>();
		
		for(String string : text.toLowerCase().split(" ")) {
			if(string.contains(".")) {
				for(String subString : string.split(".")) {
					resultStringSet.add(subString);
				}
			}else if (string.contains(",")) {
				for(String subString : string.split(",")) {
					resultStringSet.add(subString);
				}
			}else {
				resultStringSet.add(string);
			}
		}
		
		return resultStringSet;
	}

}
