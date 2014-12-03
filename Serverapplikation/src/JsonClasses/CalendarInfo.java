package JsonClasses;

// TODO: Auto-generated Javadoc
/**
 * The Class CalendarInfo.
 */
public class CalendarInfo implements java.io.Serializable {

		private  final long serialVersionUID = 1L;
		private String overallID = "calendarInfo";
		private String activityID;
		private String calendarID;
		private String start;
		private String end;
		private String location;
		private String calendarName;
		private String createdby;
		private int publicOrPrivate;
	
		
		
		public String getOverallID() {
			return overallID;
		}
		
		public String getCalendarID() {
			return calendarID;
		}

		public void setCalendarID(String calendarID) {
			this.calendarID = calendarID;
		}

		public long getSerialVersionUID() {
			return serialVersionUID;
		}

		/**
		 * Sets the overall id.
		 *
		 * @param overallID the new overall id
		 */
		public void setOverallID(String overallID) {
			this.overallID = overallID;
		}
		
		/**
		 * Gets the calendar name.
		 *
		 * @return the calendar name
		 */
		public String getCalendarName() {
			return calendarName;
		}
		
		/**
		 * Sets the calendar name.
		 *
		 * @param calendarName the new calendar name
		 */
		public void setCalendarName(String calendarName) {
			this.calendarName = calendarName;
		}
		
		/**
		 * Gets the user name.
		 *
		 * @return the user name
		 */
		public String getCreatedby() {
			return createdby;
		}
		
		/**
		 * Sets the user name.
		 *
		 * @param userName the new user name
		 */
		public void setCreatedby(String createdby) {
			this.createdby = createdby;
		}
		
		/**
		 * Gets the public or private.
		 *
		 * @return the public or private
		 */
		public int getPublicOrPrivate() {
			return publicOrPrivate;
		}
		
		/**
		 * Sets the public or private.
		 *
		 * @param publicPrivate the new public or private
		 */
		public void setPublicOrPrivate(int publicPrivate) {
			this.publicOrPrivate = publicPrivate;
		}
		
		
		public String getStart() {
			return start;
		}
		public void setStart(String start) {
			this.start = start;
		}

		
		public String getEnd() {
			return end;
		}
		public void setEnd(String end) {
			this.end = end;
		}
		
	
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}

		
		public String getActivityID() {
			return activityID;
		}
		public void setActivityID(String activityID) {
			this.activityID = activityID;
		}
		
		
		
}