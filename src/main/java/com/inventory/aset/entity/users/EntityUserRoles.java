/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.entity.users;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author newbiecihuy
 */
@Entity
@Table(name="tbl_user_roles")
@NamedQueries({@javax.persistence.NamedQuery(name="EntityUserRoles.findByUserName", query="SELECT u FROM EntityUserRoles u WHERE u.user_roles_pk.id = :id"),
    @javax.persistence.NamedQuery(name="EntityUserRoles.findByRoleName", query="SELECT u FROM EntityUserRoles u WHERE u.user_roles_pk.roleName = :roleName")})
@XmlRootElement
public class EntityUserRoles
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected EntityUserRolesPK user_roles_pk;
  
  public EntityUserRoles() {}
  
  public EntityUserRoles(EntityUserRolesPK user_roles_pk)
  {
    this.user_roles_pk = user_roles_pk;
  }
  
  public EntityUserRolesPK getUser_roles_pk()
  {
    return user_roles_pk;
  }
  
  public void setUser_roles_pk(EntityUserRolesPK user_roles_pk) {
    this.user_roles_pk = user_roles_pk;
  }
  
  @Override
  public int hashCode()
  {
    int hash = 0;
    hash += (user_roles_pk != null ? user_roles_pk.hashCode() : 0);
    return hash;
  }
  

  @Override
  public boolean equals(Object object)
  {
    if (!(object instanceof EntityUserRoles)) {
      return false;
    }
    EntityUserRoles other = (EntityUserRoles)object;
    return !(((user_roles_pk == null) && (user_roles_pk != null)) || ((user_roles_pk != null) && (!user_roles_pk.equals(user_roles_pk))));
  }
  

    @Override
    public String toString() {
        return "com.inventory.aset.entity.EntityUserRoles[ user_roles_pk=" + user_roles_pk + " ]";
    }
    
}
