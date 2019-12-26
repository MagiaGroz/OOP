package src;
import java.io.Serializable;
import java.util.Date;
public class Order implements Serializable {
private static final long serialVersionUID = -3081729826908890189L;
String order;
 Date orderDate;
 public boolean isDone;
 
 
 public Order(String order, Date orderDate) {
  super();
  this.order = order;
  this.orderDate = orderDate;
  this.isDone = false;
 }

 public boolean isDone() {
  return isDone;
 }

 public void setDone(boolean isDone) {
  this.isDone = isDone;
 }

 public Order() {}
 
 
 public String getOrder() {
  return order;
 }
 
 public void setOrder(String order) {
  this.order = order;
 }
 
 public Date getOrderDate() {
  return orderDate;
 }
 
 public void setOrderDate(Date orderDate) {
  this.orderDate = orderDate;
 }
 
 

 @Override
 public int hashCode() {
  final int prime = 31;
  int result = 1;
  result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
  result = prime * result + ((order == null) ? 0 : order.hashCode());
  return result;
 }

 @Override
 public boolean equals(Object obj) {
  if (this == obj)
   return true;
  if (obj == null)
   return false;
  if (getClass() != obj.getClass())
   return false;
  
  Order other = (Order) obj;
  
  if (orderDate == null) {
   if (other.orderDate != null)
    return false;
  } else if (!orderDate.equals(other.orderDate))
   return false;
  if (order == null) {
   if (other.order != null)
    return false;
  } else if (!order.equals(other.order))
   return false;
  return true;
 }



 @Override
 public String toString() {
  return "Order=" + order + ", orderDate=" + orderDate  + "]";
 }
 
}