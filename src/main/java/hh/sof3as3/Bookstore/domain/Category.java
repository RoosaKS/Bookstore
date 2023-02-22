package hh.sof3as3.Bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
	 @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
		private Long id;
		private String name;
			
		
		public Category() {
			super();
			this.name = null;
		}

		public Category(String name) {
			super();
			this.name = name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		@Override
		public String toString() {
			return "id=" + id + ", name=" + name;
		}
		
		
		
}
