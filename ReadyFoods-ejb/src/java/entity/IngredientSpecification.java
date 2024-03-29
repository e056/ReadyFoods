package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import util.enumeration.PreparationMethod;

@Entity
public class IngredientSpecification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingredientSpecificationId;
    @Column(nullable = false)
    @NotNull
    @Min(1)
    private Integer quantityPerServing;
    private PreparationMethod preparationMethod;
    @JoinColumn(nullable = false)
    @NotNull
    private Ingredient ingredient;
    
    public IngredientSpecification() {
    }
    
        public IngredientSpecification(Integer quantityPerServing) {
        this.quantityPerServing = quantityPerServing;
        this.preparationMethod = null;
    }
    
    public IngredientSpecification(Integer quantity, PreparationMethod preparationMethod) {
        this.quantityPerServing = quantity;
        this.preparationMethod = preparationMethod;
    }
        
    public IngredientSpecification(Integer quantity, Ingredient ingredient, PreparationMethod preparationMethod) {
        this.quantityPerServing = quantity;
        this.ingredient = ingredient;
        this.preparationMethod = preparationMethod;
    }
    
    
    public Long getIngredientSpecificationId() {
        return ingredientSpecificationId;
    }

    public void setIngredientSpecificationId(Long ingredientSpecificationId) {
        this.ingredientSpecificationId = ingredientSpecificationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ingredientSpecificationId != null ? ingredientSpecificationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the ingredientSpecificationId fields are not set
        if (!(object instanceof IngredientSpecification)) {
            return false;
        }
        IngredientSpecification other = (IngredientSpecification) object;
        if ((this.ingredientSpecificationId == null && other.ingredientSpecificationId != null) || (this.ingredientSpecificationId != null && !this.ingredientSpecificationId.equals(other.ingredientSpecificationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.IngredientSpecifcationEntity[ id=" + ingredientSpecificationId + " ]";
    }

    public Integer getQuantityPerServing() {
        return quantityPerServing;
    }

    public void setQuantityPerServing(Integer quantityPerServing) {
        this.quantityPerServing = quantityPerServing;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public PreparationMethod getPreparationMethod() {
        return preparationMethod;
    }

    public void setPreparationMethod(PreparationMethod preparationMethod) {
        this.preparationMethod = preparationMethod;
    }

    
}
