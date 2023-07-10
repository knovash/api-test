package org.itacademy.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    public String _volume;
    public String _count;
    public String _mode;
    public String _path;
}
