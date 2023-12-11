package id.aldin.cimb.test.util;

public class Constants {
	
	 public enum RESPONSE {
	        APPROVED("00", "Approved"),
	        HTTP_INTERNAL_ERROR("X5", "Service Internal Error"),
	        INVALID_TRANSACTION("12", "Invalid Transaction"),
	        DATA_NOT_FOUND("14", "Data Tidak ditemukan"),
	        WRONG_FORMAT_DATA("30", "Format Data Salah"),
	        CLIENT_SERVICE_ERROR("40", "Client Service Error/Timeout"),
	        
	        ;
	        private String code, description;

	        RESPONSE(String code, String description) {
	            this.code = code;
	            this.description = description;
	        }

	        public String getCode() {
	            return this.code;
	        }

	        public String getDescription() {
	            return this.description;
	        }
	    }

}
