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

package de.ubleipzig.iiifproducer.doc;

//import static de.ubleipzig.iiifproducer.doc.MetsConstants.GOOBI_TYPE;
//import static de.ubleipzig.iiifproducer.doc.MetsConstants.METS_PARENT_LOGICAL_ID;
//import static de.ubleipzig.iiifproducer.doc.MetsConstants.SWB_TYPE;
//import static de.ubleipzig.iiifproducer.doc.MetsConstants.URN_TYPE;
import static de.ubleipzig.iiifproducer.doc.MetsManifestBuilder.getAuthor;
import static de.ubleipzig.iiifproducer.doc.MetsManifestBuilder.getCallNumber;
import static de.ubleipzig.iiifproducer.doc.MetsManifestBuilder.getCoordinates;
import static de.ubleipzig.iiifproducer.doc.MetsManifestBuilder.getDateIssued;
import static de.ubleipzig.iiifproducer.doc.MetsManifestBuilder.getExtentAltkarte;
import static de.ubleipzig.iiifproducer.doc.MetsManifestBuilder.getLanguage;
import static de.ubleipzig.iiifproducer.doc.MetsManifestBuilder.getLicense;
import static de.ubleipzig.iiifproducer.doc.MetsManifestBuilder.getManifestTitle;
import static de.ubleipzig.iiifproducer.doc.MetsManifestBuilder.getManuscriptIdByType;
import static de.ubleipzig.iiifproducer.doc.MetsManifestBuilder.getNotesByType;
import static de.ubleipzig.iiifproducer.doc.MetsManifestBuilder.getOwner;
import static de.ubleipzig.iiifproducer.doc.MetsManifestBuilder.getPlace;
import static de.ubleipzig.iiifproducer.doc.MetsManifestBuilder.getPublisher;
import static de.ubleipzig.iiifproducer.doc.MetsManifestBuilder.getReference;
import static de.ubleipzig.iiifproducer.doc.MetsManifestBuilder.getScale;
import static de.ubleipzig.iiifproducer.doc.MetsManifestBuilder.getSubtitle;
import static de.ubleipzig.iiifproducer.doc.MetsManifestBuilder.getTechnique;
import static org.slf4j.LoggerFactory.getLogger;

import de.ubleipzig.iiifproducer.template.TemplateMetadata;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

/**
 * StandardMetadata.
 *
 * @author christopher-johnson
 */
public class AltkarteMetadata {

    private static Logger logger = getLogger(AltkarteMetadata.class);

    private MetsData mets;

    /**
     * @param mets MetsData
     */
    public AltkarteMetadata(final MetsData mets) {
        this.mets = mets;
    }

    /**
     * @return List
     */
    public List<TemplateMetadata> getInfo() {
        final List<TemplateMetadata> meta = new ArrayList<>();

        meta.add(new TemplateMetadata("Titel", getManifestTitle(mets)));
        meta.add(new TemplateMetadata("Titelzusatz", getSubtitle(mets)));
        meta.add(new TemplateMetadata("Autor oder Urheber", getAuthor(mets)));
        meta.add(new TemplateMetadata("Erscheinungs- oder Entstehungsort", getPlace(mets)));
        meta.add(new TemplateMetadata("Verlag", getPublisher(mets)));
        meta.add(new TemplateMetadata("Erscheinungs- oder Entstehungsjahr", getDateIssued(mets)));
        meta.add(new TemplateMetadata("Grafische Technik", getTechnique(mets)));
        final List<String> extent = getExtentAltkarte(mets);
        for (String ex : extent) {
            meta.add(new TemplateMetadata("Umfang", ex));
        }
        meta.add(new TemplateMetadata("Maﬂstab", getScale(mets)));
        final List<String> coordinates = getCoordinates(mets);
        for (String co : coordinates) {
            meta.add(new TemplateMetadata("Koordinaten", co));
        }
        meta.add(new TemplateMetadata("Sprache", getLanguage(mets)));
        meta.add(new TemplateMetadata("Weitere Informationen", getNotesByType(mets, "source note")));
        meta.add(new TemplateMetadata("Signatur", getCallNumber(mets)));
        meta.add(new TemplateMetadata("Lizenz", getLicense(mets)));
        meta.add(new TemplateMetadata("Persistente URL", getManuscriptIdByType(mets, "purl")));
        meta.add(new TemplateMetadata("Besitzer", getOwner(mets)));
        //meta.add(new TemplateMetadata("structure", getLogicalType(mets, METS_PARENT_LOGICAL_ID)));
        meta.add(new TemplateMetadata("IKAR", getReference(mets)));

        logger.debug("Altkarte Metadata Added");
        return meta;
    }
}