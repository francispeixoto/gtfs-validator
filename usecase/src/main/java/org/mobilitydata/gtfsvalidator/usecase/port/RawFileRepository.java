/*
 * Copyright (c) 2020. MobilityData IO.
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

package org.mobilitydata.gtfsvalidator.usecase.port;

import org.mobilitydata.gtfsvalidator.domain.entity.RawEntity;
import org.mobilitydata.gtfsvalidator.domain.entity.RawFileInfo;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * This holds information about a GTFS dataset to validate.
 */
public interface RawFileRepository {
    float MAX_RAW_INPUT_SIZE_MEGABYTES = 65f;

    RawFileInfo create(RawFileInfo fileInfo);

    Optional<RawFileInfo> findByName(String filename);

    List<String> getActualHeadersForFile(RawFileInfo file);

    Set<String> getFilenameAll();

    Optional<RawEntityProvider> getProviderForFile(RawFileInfo file);

    interface RawEntityProvider {

        boolean hasNext();

        RawEntity getNext();

        int getHeaderCount();
    }
}
