/**
 *  This is a group project. 2 Students can be in one group.
 *  You can do the project alone.  
 *  Each student has to submit. 
 *  *  Deadline: 4:00pm     Late deadline: 11:59pm  Late penalty: 50% 
 *  Write your group members here:
 *  	Student 1:
 *  	Student 2: 
 */

package date;
import static org.junit.Assert.assertEquals;

import java.util.Calendar;

public class Date implements Comparable<Date>{

	private static final int[] DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	protected final int month;
	protected final int day;
	protected final int year;

	/*
	 * Initialized a new date from the month, day and year.
	 * @param month the month (between 1 and 12)
	 * @param day the day (between 1 and 28-31, depending on the month)
	 * @param year the year

	 */

	public Date(int month, int day, int year){
		if(!isValid(month, day, year)){
			System.out.println("Invalid Date");
			throw new IllegalArgumentException();
		}
		this.year = year;
		this.month = month;
		this.day = day;
	}

	/*
	 * @return month of that month
	 */
	public int getMonth(){
		return this.month;
	}

	/*
	 * @return day of that day
	 */
	public int getDay(){
		return this.day;
	}

	/*
	 * @return year of that year
	 */
	public int getYear(){
		return this.year;
	}

	/**
	 * This method checks if a given date is a valid calendar date
	 * 
	 * @param m  month
	 * @param d  day
	 * @param y  year. (A year is no less than 1900, and no greater than 2100)
	 * @return  true if the given date is a valid calendar date. false otherwise
	 */
	public static boolean isValid(int m, int d, int y){
		boolean valid = false;

		if((y >= 1900 && y <= 2100) && ( m >= 1 && m <= 12 ) && (d >= 1 && d <= 31)) {
			if(m == 1 && d <= 31) {
				valid = true;
			}else if(m == 2 && d <= 29) {
				if(d == 29) {
					valid = isLeapYear(y);
				}else {
					valid = true;
				}
			}else if(m == 3 && d <= 31) {
				valid = true;
			}else if(m == 4 && d <= 30) {
				valid = true;
			}else if(m == 5 && d <= 31){
				valid = true;
			}else if(m == 6 && d <= 30) {
				valid = true;
			}else if(m == 7 && d <= 31) {
				valid = true;
			}else if(m == 8 && d <= 31) {
				valid = true;
			}else if(m == 9 && d <= 30) {
				valid = true;
			}else if(m == 10 && d <= 31) {
				valid = true;
			}else if(m == 11 && d <= 30) {
				valid = true;
			}else if(m == 12 && d <= 31) {
				valid = true;
			}
		}

		return valid;

	}


	/** 
	 * @param year
	 * @return true if the given year is a leap year. false otherwise.
	 */
	public static boolean isLeapYear(int year){

		return ((year % 4 == 0) && (year % 100 != 0 || year % 400 == 0));
	}

	/**
	 * Compare this date to that day.
	 * @return {-1,0,1}, depending on whether this date is {before, equal to, after} that date
	 */

	public int compareTo(Date that) {
		if(this.year == that.year) {

			if(this.month == that.month) {
				if(this.day == that.day) {
					return 0;
				}else if(this.day > that.day) {
					return 1;
				}else {
					return -1;
				}

			}else if(this.month > that.month) {
				return 1;

			}else {
				return -1;
			}
		}else if (this.year > that.year) {
			return 1;
		}else {
			return -1;
		}

	}

	/**
	 * Return a string representation of this date.
	 * No 0-padding needed
	 * @return the string representation in the format MM/DD/YYYY
	 */
	public String toString(){

		return month + "/" + day + "/" + year;
	}


	/**
	 * 
	 * @return the word representation of the date.
	 * Example: (new Date(12,1,2017)).dateToWords() returns "December One Two Thousand Seventeen" 
	 */
	public String dateToWords() {
		String[] monthWords = {"January", "February", "March", "April", "May", "June", "July", "August", "September","October", "November", "December"};
		String[] numbersLessThanTen = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
		String[] numbersBetweenTenAndTwenty = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
		String[] multiplesOfTen = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
		String[] yearWords = {"Hundred", "Thousand"};


		String toReturn = "";

		
		toReturn =  toReturn + monthWords[month - 1] + " ";

		if(day < 10) {
			toReturn = toReturn + numbersLessThanTen[day - 1]+ " ";
		}else if(day > 10 && day < 20 ){
			toReturn = toReturn + numbersBetweenTenAndTwenty[day - 1] + " ";
		}else if(day > 20 && day < 30 || day == 31) {
			toReturn = toReturn + multiplesOfTen[day/10 - 1] + " " +  numbersLessThanTen[day % 10 - 1] + " " ;
		}else if (day % 10 == 0) {
			toReturn = toReturn + multiplesOfTen[day /10 - 1] + " ";
		}

		String yearStr = Integer.toString(year);
		
		for(int i = 0; i < yearStr.length(); i++) {
			if(i == 0) {
				if(Character.getNumericValue(yearStr.charAt(i)) > 0) {
					toReturn = toReturn + numbersLessThanTen[Character.getNumericValue(yearStr.charAt(i)) - 1]+ " " + yearWords[1] + " ";
				}else {
					continue;
				}
				
			}else if(i== 1) {
				if(Character.getNumericValue(yearStr.charAt(i)) > 0) {
					toReturn = toReturn + numbersLessThanTen[Character.getNumericValue(yearStr.charAt(i)) - 1]+ " " + yearWords[0] + " ";
				}else {
					continue;
				}
				
			}else if(i == 2) {
				if(Character.getNumericValue(yearStr.charAt(i)) > 0) {
					if(Character.getNumericValue(yearStr.charAt(i)) == 1) {
						toReturn = toReturn + numbersBetweenTenAndTwenty[Character.getNumericValue(yearStr.charAt(3)) - 1]+ " ";
						break;
					}else if(Character.getNumericValue(yearStr.charAt(i)) > 1) {
						toReturn = toReturn + multiplesOfTen[Character.getNumericValue(yearStr.charAt(i)) - 1]+ " ";
					}
				}else {
					continue;
				}
			}else if(i == 3) {
				if(Character.getNumericValue(yearStr.charAt(i)) > 0) {
					toReturn = toReturn + numbersLessThanTen[Character.getNumericValue(yearStr.charAt(i)) - 1];
				}
			}	
		}
		
		return toReturn;
	}

	/**
	 * @return the age of a person born on this date
	 * Example : (new Date(5,31,1998)).age() returns 20
	 */

	public int age(){
		Calendar cal = Calendar.getInstance();
		int d = cal.get(Calendar.DAY_OF_MONTH);
		int m = cal.get(Calendar.MONTH);		//starts from 0 to 11
		int y = cal.get(Calendar.YEAR);

		int age = 0;

		if(month == m + 1) {
			if(day == d || day > d) {
				age++;
			}
		}else if(month  > m + 1) {
			age--;
		}

		age = age + y - year;

		return age;
	}

}
