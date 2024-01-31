package com.luismata.mypnademo.customer.core.model;

public record CustomerDTO(int customerId, String customerName) {
    public static final class CustomerDTOBuilder {
        private int customerID;
        private String customerName;

        public CustomerDTOBuilder(int customerID) {
            this.customerID = customerID;
        }

        public CustomerDTOBuilder withCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public CustomerDTO build() {
            return new CustomerDTO(this.customerID, this.customerName);
        }

    }
}
