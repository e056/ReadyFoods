/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author PYT
 */
@Entity
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    
    @Column(nullable = false)
    @NotNull
    @Min(1)
    private Integer numPax;
    
    @Column(nullable = false, precision = 11, scale = 2)
    @NotNull
    @DecimalMin("0.00")
    @Digits(integer = 9, fraction = 2) // 11 - 2 digits to the left of the decimal point
    private BigDecimal totalCost;
    
    @Column(nullable = false)
    @NotNull
    private Boolean paid;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @NotNull
    private Date dateOfOrder;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @NotNull
    private Date dateForDelivery;
    
    @Column(nullable = false)
    @NotNull
    private Boolean delivered;
    
    @Size(max = 128)
    private String additionalNotes;
    
    @OneToMany
    private List<OrderLineItem> recipes;
    
    @ManyToOne(optional = true)
    @JoinColumn(nullable = true)
    private Customer customer;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the orderId fields are not set
        if (!(object instanceof Order)) {
            return false;
        }
        Order other = (Order) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Order[ id=" + orderId + " ]";
    }

    /**
     * @return the numPax
     */
    public Integer getNumPax() {
        return numPax;
    }

    /**
     * @param numPax the numPax to set
     */
    public void setNumPax(Integer numPax) {
        this.numPax = numPax;
    }

    /**
     * @return the totalCost
     */
    public BigDecimal getTotalCost() {
        return totalCost;
    }

    /**
     * @param totalCost the totalCost to set
     */
    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    /**
     * @return the paid
     */
    public Boolean getPaid() {
        return paid;
    }

    /**
     * @param paid the paid to set
     */
    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    /**
     * @return the dateOfOrder
     */
    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    /**
     * @param dateOfOrder the dateOfOrder to set
     */
    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    /**
     * @return the dateForDelivery
     */
    public Date getDateForDelivery() {
        return dateForDelivery;
    }

    /**
     * @param dateForDelivery the dateForDelivery to set
     */
    public void setDateForDelivery(Date dateForDelivery) {
        this.dateForDelivery = dateForDelivery;
    }

    /**
     * @return the delivered
     */
    public Boolean getDelivered() {
        return delivered;
    }

    /**
     * @param delivered the delivered to set
     */
    public void setDelivered(Boolean delivered) {
        this.delivered = delivered;
    }

    /**
     * @return the additionalNotes
     */
    public String getAdditionalNotes() {
        return additionalNotes;
    }

    /**
     * @param additionalNotes the additionalNotes to set
     */
    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    /**
     * @return the recipes
     */
    public List<OrderLineItem> getRecipes() {
        return recipes;
    }

    /**
     * @param recipes the recipes to set
     */
    public void setRecipes(List<OrderLineItem> recipes) {
        this.recipes = recipes;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
}