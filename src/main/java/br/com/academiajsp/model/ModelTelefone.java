package br.com.academiajsp.model;

import java.io.Serializable;
import java.util.Objects;

public class ModelTelefone implements Serializable {

    private static final long serialVersionUID = 1L;

    private String numero;
    private Long id;
    private ModelLogin cliente_pai_id;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ModelLogin getCliente_pai_id() {
        return cliente_pai_id;
    }

    public void setCliente_pai_id(ModelLogin cliente_pai_id) {
        this.cliente_pai_id = cliente_pai_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModelTelefone)) return false;
        ModelTelefone that = (ModelTelefone) o;
        return Objects.equals(getNumero(), that.getNumero()) && Objects.equals(getId(), that.getId()) && Objects.equals(getCliente_pai_id(), that.getCliente_pai_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumero(), getId(), getCliente_pai_id());
    }
}
