package com.wkgp.dataSources

import com.wkgp.model.Tag
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TagRepository : CrudRepository<Tag, Long> {

}
