package com.laces.form.dto

import com.laces.form.core.Form

data class FlowResponse(
        val title: String,
        val submissionUrl: String,
        val flowSteps : List<FlowStepResponse>
)

data class FlowStepResponse(
        val formMetaData: List<Form>,
        val title: String,
        val fieldName: String,
        val asArray: Boolean
)