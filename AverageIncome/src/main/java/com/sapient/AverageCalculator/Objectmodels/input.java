package com.sapient.AverageCalculator.Objectmodels;

public class input {
         public String city;
         public String country;
         public double averageincome;
         public Currency currency;
         public Gender gender;
		public input(String city, String country, double averageincome, Currency currency, Gender gender) {
			super();
			this.city = city;
			this.country = country;
			this.averageincome = averageincome;
			this.currency = currency;
			this.gender = gender;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public double getAverageincome() {
			return averageincome;
		}
		public void setAverageincome(double averageincome) {
			this.averageincome = averageincome;
		}
		public Currency getCurrency() {
			return currency;
		}
		public void setCurrency(Currency currency) {
			this.currency = currency;
		}
		public Gender getGender() {
			return gender;
		}
		public void setGender(Gender gender) {
			this.gender = gender;
		}      
}
