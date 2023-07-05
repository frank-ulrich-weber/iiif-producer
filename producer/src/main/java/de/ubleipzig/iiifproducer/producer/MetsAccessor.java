/*
 * IIIFProducer
 * Copyright (C) 2017 Leipzig University Library <info@ub.uni-leipzig.de>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package de.ubleipzig.iiifproducer.producer;

import de.ubleipzig.iiifproducer.doc.MetsData;
import de.ubleipzig.iiifproducer.template.TemplateManifest;
import de.ubleipzig.iiifproducer.template.TemplateMetadata;
import de.ubleipzig.iiifproducer.template.TemplateStructure;
import de.ubleipzig.iiifproducer.template.TemplateTopStructure;

import java.util.List;
import java.util.Map;

/**
 * MetsAccessor.
 *
 * @author christopher-johnson
 */
public interface MetsAccessor {

    /**
     * @param body TemplateManifest
     */
    void setManifestLabel(TemplateManifest body);

    /**
     * @param body TemplateManifest
     */
    void setLicense(TemplateManifest body);


    /**
     * @param body TemplateManifest
     */
    void setAttribution(TemplateManifest body);

    /**
     * @param body TemplateManifest
     */
    void setLogo(TemplateManifest body);

    /**
     * @param body TemplateManifest
     */
    void setHandschriftMetadata(TemplateManifest body);

    /**
     * @param body TemplateManifest
     */
    void setAltkarteMetadata(TemplateManifest body);

    /**
     * @param body TemplateManifest
     */
    void setMetadata(TemplateManifest body);

    /**
     * @return TemplateMetadata
     */
    TemplateMetadata getAnchorFileMetadata();

    /**
     * @return String
     */
    String getAnchorFileLabel();

    /**
     * @return Map
     */
    Map<String, List<MetsData.Xlink>> getXlinkMap();

    /**
     * @param logical String
     * @return List
     */
    List<String> getCanvases(String logical);

    /**
     * @return TemplateTopStructure
     */
    TemplateTopStructure buildTopStructure();

    /**
     * @return List
     */
    List<TemplateStructure> buildStructures();

    /**
     *
     * @param logicalType String
     * @return List
     */
    List<TemplateMetadata> buildStructureMetadata(String logicalType);

    /**
     * @return String
     */
    Boolean getMtype();

    /**
     * @return String
     */
    Boolean getAtype();

    /**
     * @return String
     */
    String getUrnReference();

    /**
     * @return List
     */
    List<String> getPhysical();

    /**
     * @param div String
     * @return String
     */
    String getOrderLabel(String div);

    /**
     * @param div String
     * @return String
     */
    String getFile(String div);

    /**
     * @param file String
     * @return String
     */
    String getHref(String file);
}
