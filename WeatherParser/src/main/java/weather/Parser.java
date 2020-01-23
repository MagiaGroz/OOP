package weather;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parser {

	private static Document getPage() throws MalformedURLException, IOException {
		String url = "http://www.nepogoda.ru/asia/kazakhstan/almaty/";
		Document page = Jsoup.parse(new URL(url),4000);
		return page;
	}
	
	private static Pattern pattern = Pattern.compile("\\d{2}\\.\\d{2}"); // \d{2} two symbols \. - point \d{2} - two symbols
	
	private static String getDateFromStr(String strDate) throws Exception {
		Matcher matcher = pattern.matcher(strDate);
		if(matcher.find()) {
			return matcher.group();
		}
		throw new Exception("Can't extract date from string");
	}
	public static int index = 0;
	private static int printFourValues(Elements values,int index) {
		
		if(index==0) {
			int j=4;
			if(values.get(index).select("td").text().contains("День"))
				j=3;
			else if(values.get(index).select("td").text().contains("Вечер"))
				j=2;
			else if(values.get(index).select("td").text().contains("Ночь"))
				j=5;
				for(int i=0;i<j;i++) {
			for(Element td: values.get(index).select("td")) {
				System.out.print(td.text()+"    ");
			}
			System.out.print("\n");
			index++;
			
				}
				return index;		
		}
		else {
		for(int i=0;i<4;i++) {
			if(values.size()<=index)
				break;
			for(Element td: values.get(index).select("td")) {
				System.out.print(td.text()+"    ");
			}
			System.out.print("\n");
			index++;
		}
		return index;
		}
	}
	public static void main(String[] args) throws Exception {
		Document page = getPage();

		//css query lang
		Element tablewth = page.select("table[class=wt]").first();
		Elements names = tablewth.select("tr[class=wth]");
		Elements values = tablewth.select("tr[valign=top]");
		
		for(Element name: names) {
		String dateStr=name.select("th[id=dt]").text();
		String date = getDateFromStr(dateStr);
		System.out.println(date + "    Явления                температура    давление    влажность    ветер");
		index = printFourValues(values, index);
		
		}
	}

}
