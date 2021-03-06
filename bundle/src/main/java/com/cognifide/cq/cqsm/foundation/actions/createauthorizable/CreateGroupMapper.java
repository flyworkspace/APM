/*-
 * ========================LICENSE_START=================================
 * AEM Permission Management
 * %%
 * Copyright (C) 2013 Cognifide Limited
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */
package com.cognifide.cq.cqsm.foundation.actions.createauthorizable;

import com.cognifide.cq.cqsm.api.actions.Action;
import com.cognifide.cq.cqsm.api.actions.BasicActionMapper;
import com.cognifide.cq.cqsm.api.actions.annotations.Mapping;

public class CreateGroupMapper extends BasicActionMapper {

	public static final String REFERENCE = "Create a group.";

	@Mapping(
			value = {"CREATE" + DASH + "GROUP" + SPACE + STRING},
			args = {"groupId"},
			reference = REFERENCE
	)
	public Action mapAction(String id) {
		return mapAction(id, null, false);
	}

	@Mapping(
			value = {"CREATE" + DASH + "GROUP" + SPACE + STRING + SPACE + PATH},
			args = {"groupId", "path"},
			reference = REFERENCE
	)
	public Action mapAction(String id, String path) {
		return mapAction(id, path, false);
	}

	@Mapping(
			value = {"CREATE" + DASH + "GROUP" + SPACE + STRING + SPACE + ("IF" + DASH + "NOT" + DASH + "EXISTS")},
			args = {"groupId"},
			reference = REFERENCE
	)
	public Action mapActionWithIfNotExists(String id) {
		return mapAction(id, null, true);
	}

	@Mapping(
			value = {"CREATE" + DASH + "GROUP" + SPACE + STRING + SPACE + PATH + SPACE + ("IF" + DASH + "NOT" + DASH + "EXISTS")},
			args = {"groupId", "path"},
			reference = REFERENCE
	)
	public Action mapActionWithIfNotExists(String id, String path) {
		return mapAction(id, path, true);
	}

	private Action mapAction(String id, String path, Boolean ifNotExists) {
		return new CreateAuthorizable(id, null, path, ifNotExists, CreateAuthorizableStrategy.GROUP);
	}

}
