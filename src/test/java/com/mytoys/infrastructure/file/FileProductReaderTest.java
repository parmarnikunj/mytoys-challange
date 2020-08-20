package com.mytoys.infrastructure.file;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FileProductReaderTest {

    private FileProductReader fileProductReader = new FileProductReader();

    @Test
    public void testFileReaderFindAll() {
        assertThat(fileProductReader.readAll()).isNotEmpty().hasSize(521);
    }
}