package com.hermes.msg.model;

import javax.persistence.*;

@Entity(name="message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="origin",nullable = false)
    private String origin;

    @Column(name="destination",nullable = false)
    private String destination;

    @Column(name="cc")
    private String cc;

    @Column(name="bcc")
    private String bcc;

    @Column(name="subject", nullable = false)
    private String subject;

    @Column(name="body")
    private String body;

    @Column(name="attachment")
    private String attachment;

    public Message(Integer id, String origin, String destination, String cc, String bcc, String subject, String body, String attachment) {
        super();
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.cc = cc;
        this.bcc = bcc;
        this.subject = subject;
        this.body = body;
        this.attachment = attachment;
    }

    public Message(String origin, String destination, String cc, String bcc, String subject, String body, String attachment) {
        super();
        this.origin = origin;
        this.destination = destination;
        this.cc = cc;
        this.bcc = bcc;
        this.subject = subject;
        this.body = body;
        this.attachment = attachment;
    }

    public Message() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", cc='" + cc + '\'' +
                ", bcc='" + bcc + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", attachment='" + attachment + '\'' +
                '}';
    }
}
