package JsonClasses;

// TODO: Auto-generated Javadoc
/**
 * The Class CalendarInfo.
 */
public class CalendarInfo implements java.io.Serializable {

		/** The serial version uid. */
		private  final long serialVersionUID = 1L;
		
		/** The overall id. */
		private String overallID = "calendarInfo";
		
		/** The calendar id. */
		private String calendarID;
		
		/** The calendar name. */
		private String calendarName;
		
		/** The createdby. */
		private String createdby;
		
		/** The public or private. */
		private int publicOrPrivate;
		
		/** The active. */
		private String active;
	
		
		
		/**
		 * Gets the active.
		 *
		 * @return the active
		 */
		public String getActive() {
			return active;
		}

		/**
		 * Sets the active.
		 *
		 * @param active the new active
		 */
		public void setActive(String active) {
			this.active = active;
		}

		/**
		 * Gets the overall id.
		 *
		 * @return the overall id
		 */
		public String getOverallID() {
			return overallID;
		}
		
		/**
		 * Gets the calendar id.
		 *
		 * @return the calendar id
		 */
		public String getCalendarID() {
			return calendarID;
		}

		/**
		 * Sets the calendar id.
		 *
		 * @param calendarID the new calendar id
		 */
		public void setCalendarID(String calendarID) {
			this.calendarID = calendarID;
		}

		/**
		 * Gets the serial version uid.
		 *
		 * @return the serial version uid
		 */
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
		 * @param createdby the new createdby
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

		
		
		
}