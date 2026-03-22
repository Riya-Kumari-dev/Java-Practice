# Access Specifier

| Access Modifier | Same Class | Same Package | Outside Package (with inheritance) | Outside Package(Without inheritance) |
|-----------------|------------|--------------|------------------------------------|--------------------------------------|
| Private         | ✅          | ❌            | ❌                                  | ❌                                    |
| Default         | ✅          | ✅            | ❌                                  | ❌                                    |                                                                              
| Protected       | ✅          | ✅            | ✅ (only via inheritance)           | ❌                                    |
| Public          | ✅          | ✅            | ✅                                  | ✅                                    |