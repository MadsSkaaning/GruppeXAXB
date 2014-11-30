package shared;
public class CalendarInfo implements java.io.Serializable {

		private  final long serialVersionUID = 1L;
		private String overallID = "createCalendar";
		
		private String activityID;
		private String eventID;
		private String type;
		private String title;
		private String description;
		private String start;
		private String end;
		private String locatoin;
		
		private String calendarName;
		private String userName;
	
		private int publicOrPrivate;
		
		//Getters and setters for everything, bitch
		public String getOverallID() {
			return overallID;
		}
		public void setOverallID(String overallID) {
			this.overallID = overallID;
		}
		public String getCalendarName() {
			return calendarName;
		}
		public void setCalendarName(String calendarName) {
			this.calendarName = calendarName;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public int getPublicOrPrivate() {
			return publicOrPrivate;
		}
		public void setPublicOrPrivate(int publicPrivate) {
			this.publicOrPrivate = publicPrivate;
		}
}