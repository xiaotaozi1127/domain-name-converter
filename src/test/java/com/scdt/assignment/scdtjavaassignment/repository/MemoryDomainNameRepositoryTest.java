package com.scdt.assignment.scdtjavaassignment.repository;

import com.scdt.assignment.scdtjavaassignment.repository.MemoryDomainNameRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemoryDomainNameRepositoryTest {

    MemoryDomainNameRepository memoryDomainNameRepository = new MemoryDomainNameRepository();

    @Test
    public void should_get_domain_name_mapping_after_save_it_in_repo() {
        memoryDomainNameRepository.saveEncodedDomain("t.cn/0", "https://www.baidu.com");
        memoryDomainNameRepository.saveEncodedDomain("t.cn/1", "https://www.sina.com");

        String decodeShortDomain = memoryDomainNameRepository.decodeShortDomain("t.cn/0");
        Assertions.assertEquals("https://www.baidu.com", decodeShortDomain);

        decodeShortDomain = memoryDomainNameRepository.decodeShortDomain("t.cn/1");
        Assertions.assertEquals("https://www.sina.com", decodeShortDomain);

        decodeShortDomain = memoryDomainNameRepository.decodeShortDomain("t.cn/notfound");
        Assertions.assertNull(decodeShortDomain);
    }

}
