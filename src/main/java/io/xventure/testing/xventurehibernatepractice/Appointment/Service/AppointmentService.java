package io.xventure.testing.xventurehibernatepractice.Appointment.Service;

import io.xventure.testing.xventurehibernatepractice.Appointment.Entity.Appointment;
import io.xventure.testing.xventurehibernatepractice.Appointment.Repository.AppointmentRepository;
import io.xventure.testing.xventurehibernatepractice.Appointment.dto.AppointmentDTO;
import io.xventure.testing.xventurehibernatepractice.Channel.Entity.Channel;
import io.xventure.testing.xventurehibernatepractice.Channel.Repository.ChannelRepository;
import io.xventure.testing.xventurehibernatepractice.Error.ErrorSelector;
import io.xventure.testing.xventurehibernatepractice.Error.GenaricException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    @Autowired
    private ChannelRepository channelRepository;

    public AppointmentDTO addAppointment(AppointmentDTO  dto){
        if(!channelRepository.existsById(dto.getChannelId())){
            throw new GenaricException(ErrorSelector.CHANNEL_NOT_FOUND);
        }else{
            Channel channel = channelRepository.findById(dto.getChannelId()).get();
            if(!(channel.getNumOfPatients()> channel.getFilledPatientsAmount())){
                throw new GenaricException(ErrorSelector.CHANNEL_IS_FILLED);
            }
            int num=channel.getFilledPatientsAmount()+1;
            channel.setFilledPatientsAmount(num);
            channelRepository.save(channel);
            Appointment save = repository.save(new Appointment(num, dto.getPatientName(), dto.getAge(), channel));
            return new AppointmentDTO(save.getId(), save.getAppointmentNum(), save.getPatientName(), save.getAge(), save.getChannel().getId());
        }
    }

    public AppointmentDTO getAppointmentById(int id){
        if(!repository.existsById(id)){
            return null;
        }else{
            Appointment appointment = repository.findById(id).get();
            return new AppointmentDTO(appointment.getId(), appointment.getAppointmentNum(), appointment.getPatientName(),appointment.getAge(),appointment.getChannel().getId());
        }
    }


    public List<AppointmentDTO> getAllAppointment(){
        List<AppointmentDTO> dtos=new LinkedList<>();
        repository.findAll().forEach(appointment -> dtos.add(new AppointmentDTO(appointment.getId(), appointment.getAppointmentNum(), appointment.getPatientName(),appointment.getAge(),appointment.getChannel().getId())));
        return dtos;
    }


    public boolean deleteAppointment(int id){
        if(!repository.existsById(id)){
            return false;
        }else{
            repository.deleteById(id);
            return true;
        }
    }

}
