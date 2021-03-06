/*
 * Copyright (c) 2015 BISON Schweiz AG, All Rights Reserved.
 */
package to.rtc.rtc2jira.importer;

import java.util.List;

import to.rtc.rtc2jira.importer.mapping.DefaultMappingRegistry;

import com.ibm.team.workitem.common.model.IAttribute;
import com.ibm.team.workitem.common.model.IWorkItem;
import com.orientechnologies.orient.core.record.impl.ODocument;

/**
 * @author roman.schaller
 *
 */
public class AttributeMapper {

  public void map(List<IAttribute> allAttributes, ODocument doc, IWorkItem workItem) {
    DefaultMappingRegistry mappingRegistry = DefaultMappingRegistry.getInstance();

    mappingRegistry.beforeWorkItem(workItem);
    for (IAttribute attribute : allAttributes) {
      if (workItem.hasAttribute(attribute)) {
        mappingRegistry.acceptAttribute(attribute);
      }
    }
    mappingRegistry.afterWorkItem(doc);
  }
}
