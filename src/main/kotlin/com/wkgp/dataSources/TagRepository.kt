package com.wkgp.dataSources

import com.wkgp.model.Tags
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TagRepository: CrudRepository<Tags, Long> {

}