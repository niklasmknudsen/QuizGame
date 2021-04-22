package dk.howard.resource;

import dk.howard.repository.entity.AnswerPO;
import dk.howard.repository.entity.AnsweredQuestionPO;
import dk.howard.resource.dto.CreateAnswerDTO;
import dk.howard.resource.dto.CreateAnsweredQuestionDTO;
import dk.howard.resource.dto.ReadAnswerDTO;
import dk.howard.resource.dto.ReadAnsweredQuestionDTO;
import dk.howard.service.AnsweredQuestionService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/answeredquestion")
@RequestScoped
public class AnsweredQuestionResource {

    private final AnsweredQuestionService service;
    private final Mapper mapper;

    @Inject
    public AnsweredQuestionResource(AnsweredQuestionService service, Mapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Path("")
    @GET
    public List<AnsweredQuestionPO> getAll(){
        return service.getAll();
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Path("")
    @POST
    public void createAnswer(CreateAnsweredQuestionDTO createAnsweredQuestionDTO){
        try {
            service.insert(mapper.mapCreateAnsweredQuestion(createAnsweredQuestionDTO));
        } catch (NoResultException exception) {
            throw new NoResultException(exception.getMessage());
        }
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @DELETE
    public void removeAnswer(@PathParam("id") int id){
        try {
            service.remove(id);
        } catch (NoResultException e) {
            throw new NoResultException(e.getMessage());
        }
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @GET
    public ReadAnsweredQuestionDTO getById(@PathParam("id") int id){
        if (id != 0) {
            ReadAnsweredQuestionDTO selectedAnswer = mapper.mapReadAnsweredQuestion(service.getById(id));
            return selectedAnswer;
        }
        return null;
    }

}
