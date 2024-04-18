package com.ms.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotBlank
    @NotEmpty
    @Size(min = 8, max = 10)
    @Pattern(regexp = "^[0-9]*$", message = "the document should be just letters")
    private String document;

    //^(?!\s*$)(?:Seven|Six|Two|One|Three| )$
    @Pattern(regexp = "^(?:TI|CC|CE)$", message = "the type document should be TI , CC or CE")
    private String typeDocument;
    // Enum  ETypeDocuments
    //private ETypeDocuments typeDocuments

    @NotBlank
    @NotEmpty
    @Pattern(regexp = "^[^0-9]*$", message = "the document should be just letters")
    @Size(min = 3)
    private String name;


    @NotBlank
    @NotEmpty
    @Pattern(regexp = "^[^0-9]*$", message = "the document should be just letters")
    @Size(min = 4)
    private String lastname;

    @NotBlank
    @NotEmpty
    @Pattern(regexp = "^[0-9]*$", message = "the document should be just letters")
    @Size(min = 8,max = 10)
    private String phoneNumber;

}
