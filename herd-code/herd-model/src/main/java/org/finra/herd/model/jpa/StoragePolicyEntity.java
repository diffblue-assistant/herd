/*
* Copyright 2015 herd contributors
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.finra.herd.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * A storage policy.
 */
@XmlRootElement
@XmlType
@Table(name = StoragePolicyEntity.TABLE_NAME)
@Entity
public class StoragePolicyEntity extends AuditableEntity
{
    /**
     * The table name.
     */
    public static final String TABLE_NAME = "strge_plcy";

    @Id
    @Column(name = TABLE_NAME + "_id")
    @GeneratedValue(generator = TABLE_NAME + "_seq")
    @SequenceGenerator(name = TABLE_NAME + "_seq", sequenceName = TABLE_NAME + "_seq")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "name_space_cd", referencedColumnName = "name_space_cd", nullable = false)
    private NamespaceEntity namespace;

    /**
     * The name column.
     */
    @Column(name = "name_tx", nullable = false)
    private String name;

    /**
     * The storage column.
     */
    @ManyToOne
    @JoinColumn(name = "strge_cd", referencedColumnName = "strge_cd")
    private StorageEntity storage;

    /**
     * The destination storage column.
     */
    @ManyToOne
    @JoinColumn(name = "dstnt_strge_cd", referencedColumnName = "strge_cd")
    private StorageEntity destinationStorage;

    /**
     * The storage policy rule type.
     */
    @ManyToOne
    @JoinColumn(name = "strge_plcy_rule_type_cd", referencedColumnName = "strge_plcy_rule_type_cd", nullable = false)
    private StoragePolicyRuleTypeEntity storagePolicyRuleType;

    /**
     * The storage policy rule value.
     */
    @Column(name = "strge_plcy_rule_value_nb", nullable = false)
    private Integer storagePolicyRuleValue;

    /**
     * The business object definition.
     */
    @ManyToOne
    @JoinColumn(name = "bus_objct_dfntn_id", referencedColumnName = "bus_objct_dfntn_id")
    private BusinessObjectDefinitionEntity businessObjectDefinition;

    /**
     * The usage column.
     */
    @Column(name = "usage_cd")
    private String usage;

    @ManyToOne
    @JoinColumn(name = "file_type_cd", referencedColumnName = "file_type_cd")
    private FileTypeEntity fileType;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public NamespaceEntity getNamespace()
    {
        return namespace;
    }

    public void setNamespace(NamespaceEntity namespace)
    {
        this.namespace = namespace;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public StorageEntity getStorage()
    {
        return storage;
    }

    public void setStorage(StorageEntity storage)
    {
        this.storage = storage;
    }

    public StorageEntity getDestinationStorage()
    {
        return destinationStorage;
    }

    public void setDestinationStorage(StorageEntity destinationStorage)
    {
        this.destinationStorage = destinationStorage;
    }

    public StoragePolicyRuleTypeEntity getStoragePolicyRuleType()
    {
        return storagePolicyRuleType;
    }

    public void setStoragePolicyRuleType(StoragePolicyRuleTypeEntity storagePolicyRuleType)
    {
        this.storagePolicyRuleType = storagePolicyRuleType;
    }

    public Integer getStoragePolicyRuleValue()
    {
        return storagePolicyRuleValue;
    }

    public void setStoragePolicyRuleValue(Integer storagePolicyRuleValue)
    {
        this.storagePolicyRuleValue = storagePolicyRuleValue;
    }

    public BusinessObjectDefinitionEntity getBusinessObjectDefinition()
    {
        return businessObjectDefinition;
    }

    public void setBusinessObjectDefinition(BusinessObjectDefinitionEntity businessObjectDefinition)
    {
        this.businessObjectDefinition = businessObjectDefinition;
    }

    public String getUsage()
    {
        return usage;
    }

    public void setUsage(String usage)
    {
        this.usage = usage;
    }

    public FileTypeEntity getFileType()
    {
        return fileType;
    }

    public void setFileType(FileTypeEntity fileType)
    {
        this.fileType = fileType;
    }
}
