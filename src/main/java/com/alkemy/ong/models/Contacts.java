package com.alkemy.ong.models;


import com.alkemy.ong.models.entity.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contacts")
@SQLDelete(sql = "UPDATE contacts SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@Entity
public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "El campo name es obligatorio.")
    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @NotBlank(message = "El campo email es obligatorio.")
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "message")
    private String message;

    @Column(name = "deleted", columnDefinition = "boolean default false")
    private boolean deleted;

    @NotNull(message = "El campo organization es obligatorio.")
    @ManyToOne()
    @JoinColumn(name = "organization_id")
    Organization organization;

}
