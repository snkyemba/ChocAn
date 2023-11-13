package chocAnSystem;
import java.util.Date;

public class ServiceRecord {

        private Date currentDate;
        private Date serviceDate;
        private int providerNumber;
        private int memberNumber;
        private int serviceCode;
        private String comments;

        public ServiceRecord(Date currentDate, Date serviceDate, int providerNumber, int memberNumber, int serviceCode, String comments) {
            this.currentDate = currentDate;
            this.serviceDate = serviceDate;
            this.providerNumber = providerNumber;
            this.memberNumber = memberNumber;
            this.serviceCode = serviceCode;
            this.comments = comments;
        }

        public Date getCurrentDate() {
            return currentDate;
        }

        public Date getServiceDate() {
            return serviceDate;
        }

        public int getProviderNumber() {
            return providerNumber;
        }

        public int getMemberNumber() {
            return memberNumber;
        }

        public int getServiceCode() {
            return serviceCode;
        }

        public String getComments() {
            return comments;
        }
}
