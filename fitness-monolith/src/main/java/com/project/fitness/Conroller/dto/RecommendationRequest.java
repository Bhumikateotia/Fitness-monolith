package project.fitness.Conroller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationRequest {
    public String userId;
    public String activityId;
    private List<String> improvements;
    private List<String> suggestions;
    private List<String> safety;

}
