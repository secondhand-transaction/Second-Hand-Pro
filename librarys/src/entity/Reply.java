package entity;

import java.sql.Timestamp;

public class Reply {
        private String name;
        private Timestamp replytime;
        private String content;
        private long stunumber;
        private int ID;
         public Reply()
         {
        	 
         }
        public Reply(String name, Timestamp replytime,String content,long stunumber )
        {
        	this.name=name;
        	this.replytime=replytime;
        	this.content=content;
        	this.stunumber=stunumber;
        	
        }

		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Timestamp getReplytime() {
			return replytime;
		}

		public void setReplytime(Timestamp replytime) {
			this.replytime = replytime;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public long getStunumber() {
			return stunumber;
		}

		public void setStunumber(long stunumber) {
			this.stunumber = stunumber;
		}
		public int getID() {
			return ID;
		}

		public void setID(int ID) {
			this.ID = ID;
		}
        
}
