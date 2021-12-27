package com.laces.form.dto

import com.laces.form.core.Form
import com.laces.form.core.FormRepository
import org.springframework.stereotype.Service

@Service
class FormService(
        private val formRepository: FormRepository
) {

    fun findByGroups(groups: Set<String>): List<Form> {
        return formRepository.findForms { formData ->
            formData.groups.any { groups.contains(it) }
        }
    }

    fun findByName(name: String): List<Form> {
        return formRepository.findForms { it.name == name }
    }

    fun getAllNames(): Set<String> {
        return formRepository.getNames()
    }

    fun getAllGroups(): Set<String> {
        return formRepository.getGroups()
    }

    fun findFlow(flowName: String): FlowResponse {
        return formRepository.findFlow(flowName)
                ?: throw RuntimeException("Unable to find flow: $flowName")
    }

    fun getFlowNames(): List<String> {
        return formRepository.getFlowNames()
    }
}
