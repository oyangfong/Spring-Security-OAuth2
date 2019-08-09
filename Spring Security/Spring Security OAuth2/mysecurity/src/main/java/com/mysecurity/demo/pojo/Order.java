package com.mysecurity.demo.pojo;


import java.io.Serializable;

    /**
     * 订单
     * */
    public class Order implements Serializable {


        private static final long serialVersionUID = 1L;

        private Long id;
        private String name;	//订单名称
        private String time;	//下单时间
        private String status; 	//订单状态
        private Double total; 	//订单总价

        public Order() {
        }

        public Order(Long id, String name, String time, String status, Double total) {
            super();
            this.id = id;
            this.name = name;
            this.time = time;
            this.status = status;
            this.total = total;
        }

        @Override
        public String toString() {
            return "Order [id=" + id + ", name=" + name + ", time=" + time + ", status=" + status + ", total=" + total
                    + "]";
        }
    }


